package com.example.demo.admin.member.service;

import com.example.demo.admin.member.entity.MemberEntity;
import com.example.demo.admin.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Log4j2
@Service
@RequiredArgsConstructor
public class MemberLoginService implements UserDetailsService {

    private final MemberRepository memberRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        log.info("================================================");
        log.info("UserDetailsService loadUserByUsername" + username);
        Optional<MemberEntity> result = memberRepository.findByUserId(username);
        if (memberRepository.findByUserId(username) == null){
            throw new UsernameNotFoundException(username);
        }
        if(!result.isPresent()){
            throw new UsernameNotFoundException("존재하지 않는 회원입니다!");
        }

        MemberEntity memberEntity = result.get();
        log.info(memberEntity);

        return User.builder()
                .username(memberEntity.getUserId())
                .password(memberEntity.getUserPw())
                .roles(memberEntity.getRoles())
                .build();
    }
}
