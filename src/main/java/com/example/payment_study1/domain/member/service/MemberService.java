package com.example.payment_study1.domain.member.service;

import com.example.payment_study1.domain.exception.CustomLogicException;
import com.example.payment_study1.domain.exception.ExceptionCode;
import com.example.payment_study1.domain.member.entity.Member;
import com.example.payment_study1.domain.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    public Member findMember(String userEmail) {
        return memberRepository.findByEmail(userEmail)
                .orElseThrow(()-> new CustomLogicException(ExceptionCode.MEMBER_NOT_FOUND));
    }

}
