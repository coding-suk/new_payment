package com.example.payment_study1.domain.user.serivce;

import com.example.payment_study1.domain.auth.AuthUser;
import com.example.payment_study1.domain.exception.CustomLogicException;
import com.example.payment_study1.domain.exception.ExceptionCode;
import com.example.payment_study1.domain.user.dto.DeleteUserRequestDto;
import com.example.payment_study1.domain.user.entity.User;
import com.example.payment_study1.domain.user.entity.UserRole;
import com.example.payment_study1.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    // 회원 탈퇴
    @Transactional
    public void deletedUser(AuthUser authUser, DeleteUserRequestDto deleteUserRequestDto) {

        // authUser 이메일로 현재 로그인한 User 찾기
        System.out.print("AuthUserEmail: " + authUser.getEmail());
        User user = userRepository.findByEmail(authUser.getEmail())
                .orElseThrow(()-> new CustomLogicException(ExceptionCode._NOT_FOUND_USER));

        // 회원의 비밀번호가 일치하는지 확인
        if(!passwordEncoder.matches(deleteUserRequestDto.getPassword(), user.getPassword())) {
            throw new CustomLogicException(ExceptionCode._PASSWORD_NOT_MATCHES);
        }

        // 이미 탈퇴한 회원인지 확인
        if(user.getEnabled()) {
            throw new CustomLogicException(ExceptionCode._DELETED_USER);
        }

        // 회원 탈퇴 메소드
        user.deletedUser(user.getEmail(), user.getPassword());

        // 변경된 내용 ㅈ장
        userRepository.save(user);
    }

    @Transactional
    public void updateUserAuthority(Long id, AuthUser authUser) {
        if(!authUser.getAuthorities().equals(UserRole.ADMIN)) {
            throw new CustomLogicException(ExceptionCode._NOT_PERMITTED_USER);
        }
        User user = userRepository.findById(id).orElseThrow(()-> new CustomLogicException(ExceptionCode._NOT_FOUND_USER));

        if(user.getEnabled()) {
            throw new CustomLogicException(ExceptionCode._DELETED_USER);
        }
        user.updatedUserRole(UserRole.ADMIN);
    }

}

