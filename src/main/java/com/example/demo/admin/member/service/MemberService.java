package com.example.demo.admin.member.service;

import com.example.demo.admin.member.entity.MemberEntity;
import com.example.demo.admin.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

//@Log4j2
//@Service
//@RequiredArgsConstructor
//public class MemberDetailService implements UserDetailsService {
//
//    private final MemberRepository memberRepository;

//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

//        log.info("UserDetailsService loadUserByUsername" + username);
//        Optional<MemberEntity> result = memberRepository.findByUserId(username,0);
//        if(result.isPresent()){
//            throw new UsernameNotFoundException("check Email or Social");
//        }
//
//        MemberEntity memberEntity = result.get();
//        log.info("================================================");
//        log.info(memberEntity);
//
//        MemberDto memberDto = new MemberDto(
//                memberEntity.getUserId(),
//                memberEntity.getUserPw(),
//                memberEntity.getFromSocial(),
//                memberEntity.getRoleSet().stream()
//                        .map(role -> new SimpleGrantedAuthority("ROLE_"+role.name())).collect(Collectors.toSet())
//                );
//
//        return memberDto;
//    }
//}
