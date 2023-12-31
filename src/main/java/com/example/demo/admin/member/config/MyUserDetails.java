package com.example.demo.admin.member.config;

import com.example.demo.admin.member.entity.MemberEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;


public class MyUserDetails implements UserDetails {
    private MemberEntity memberEntity;

    public MyUserDetails(MemberEntity memberEntity){
        this.memberEntity = memberEntity;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Collection<GrantedAuthority> collectRole=new ArrayList<>();
        collectRole.add(new GrantedAuthority() {
            @Override
            public String getAuthority() {
                //ADMIN -> ROLE_ADMIN -> Authentication  권한 등록
                return "ROLE_"+memberEntity.getRole().toString();  // 사용자 권한 설정  -> ROLE_~
            }
        });

        return collectRole;
    }
    // 사용자 비빌번호 저장 -> 시큐리티 비빌번호
    @Override
    public String getPassword() {
        return memberEntity.getUserPw();
    }
    // 사용자 아이디(email) 저장 -> 시큐리티 아이디
    @Override
    public String getUsername() {
        return memberEntity.getUserId();
    }

    // 계정 만료 여부 true : 만료 안됨
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }
    // 계정 잠김 여부 true : 잠기지 않음
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }
    // 비밀번호 만료 여부 true : 만료 안됨
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }
    // 사용자 활성화 여부  ture : 활성화
    @Override
    public boolean isEnabled() {
        return true;
    }
}
