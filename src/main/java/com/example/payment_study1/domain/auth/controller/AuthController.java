package com.example.payment_study1.domain.auth.controller;



import com.example.payment_study1.domain.auth.dto.SigninRequestDto;
import com.example.payment_study1.domain.auth.dto.SignupRequestDto;
import com.example.payment_study1.domain.auth.service.AuthService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    // 회원가입
    @PostMapping("/auth/signup")
    public String signup(@Valid @RequestBody SignupRequestDto signupRequestDto) {
        authService.signup(signupRequestDto);
        return "회원가입 완료";
    }

    // 로그인
    @PostMapping("/auth/signin")
    public ResponseEntity<String> signin(@Valid @RequestBody SigninRequestDto signinRequestDto) {
        HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.AUTHORIZATION, authService.signin(signinRequestDto));

        return ResponseEntity.ok().headers(headers).body("SUCCESS");
    }

}
