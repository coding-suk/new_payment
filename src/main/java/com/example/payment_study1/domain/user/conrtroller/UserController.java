package com.example.payment_study1.domain.user.conrtroller;

import com.example.payment_study1.domain.auth.AuthUser;
import com.example.payment_study1.domain.user.dto.DeleteUserRequestDto;
import com.example.payment_study1.domain.user.serivce.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    // 회원 탈퇴
    @DeleteMapping()
    public ResponseEntity<String> deletedUser(@AuthenticationPrincipal AuthUser authUser,
                                              @RequestBody DeleteUserRequestDto deleteUserRequestDto) {
        userService.deletedUser(authUser, deleteUserRequestDto);
        return ResponseEntity.ok("회원탈퇴가 완료되었습니다");
    }

}
