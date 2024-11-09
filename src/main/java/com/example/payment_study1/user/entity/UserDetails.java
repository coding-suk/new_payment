package com.example.payment_study1.user.entity;

import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

public interface UserDetails {

    // 사용자의 권한을 반환합니다. 일반적으로 권한은 ROLE 기반으로 관리됩니다.
    Collection<? extends GrantedAuthority> getAuthorities();

    // 사용자의 비밀번호를 반환합니다.
    String getPassword();

    // 사용자의 사용자 이름을 반환합니다.
    String getUsername();

    // 계정의 만료 여부를 반환합니다. true면 만료되지 않음을 의미합니다.
    boolean isAccountNonExpired();

    // 계정이 잠겨 있는지 여부를 반환합니다. true면 계정이 잠기지 않았음을 의미합니다.
    boolean isAccountNonLocked();

    // 자격 증명이 만료되지 않았는지 여부를 반환합니다. true면 만료되지 않음을 의미합니다.
    boolean isCredentialsNonExpired();

    // 계정이 활성화되어 있는지 여부를 반환합니다. true면 활성화됨을 의미합니다.
    boolean isEnabled();
}
