package com.example.demo.admin.member.service;

import com.example.demo.admin.member.dto.MemberDto;
import com.example.demo.admin.member.entity.MemberEntity;
import com.example.demo.admin.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MemberJoinService {

    private final PasswordEncoder passwordEncoder;
    private final MemberRepository memberRepository;

    @Transactional
    public Long memberInsert(MemberDto memberDto) {
        int rs = countMemberBysignUpId(memberDto);
        if (rs==0){
            //Dto -> Entity 변환
            MemberEntity memberEntity = new MemberEntity().builder()
                    .userId(memberDto.getUserId())
                    .userPw(passwordEncoder.encode(memberDto.getUserPw()))
                    .htel(memberDto.getHtel())
                    .name(memberDto.getName())
                    .roles("USER")
                    .build();
            memberRepository.save(memberEntity);
            return memberEntity.getId();
        }else{
            throw new IllegalStateException("이미 존재하는 회원입니다.");
        }
    }

    public int countMemberBysignUpId(MemberDto memberDto) {
        Optional<MemberEntity> memberEntityOptional = memberRepository.findByUserId(memberDto.getUserId());

        if(memberEntityOptional.isPresent()) {
            return 1;
        }else{
            return 0;
        }
    }
}
