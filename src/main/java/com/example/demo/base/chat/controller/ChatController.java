package com.example.demo.base.chat.controller;

import com.example.demo.base.chat.dto.ChatDto;
import com.example.demo.base.chat.entity.ChatEntity;
import com.example.demo.base.chat.repository.ChatRepository;
import kr.co.shineware.nlp.komoran.constant.DEFAULT_MODEL;
import kr.co.shineware.nlp.komoran.core.Komoran;
import kr.co.shineware.nlp.komoran.model.KomoranResult;
import kr.co.shineware.nlp.komoran.model.Token;
import kr.co.shineware.nlp.komoran.test.KomoranTest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class ChatController {

    private final ChatRepository chatRepository;

    @GetMapping("/chat")
    public String testChat(@RequestParam("search") String search) {
        return getKomoran(search);
    }

    public String getKomoran(String search){
        Komoran komoran = new Komoran(DEFAULT_MODEL.FULL);
        String result = "";
        String strToAnalyze = search;
//        String strToAnalyze = "챗봇아! 영화 제목을 알려줘";

        //분석할 문자열 -> komoran 전달 -> 결과값을 KomoranResult에 담음
        KomoranResult analyzeResultList = komoran.analyze(strToAnalyze);

        System.out.println(analyzeResultList.getPlainText());

        List<Token> tokenList = analyzeResultList.getTokenList();

        for (Token token : tokenList){
            System.out.format("(%2d, %2d) %s %s\n", token.getBeginIndex(), token.getEndIndex(), token.getMorph(), token.getPos());

            if(token.getPos().equals("NNG")){
                System.out.println(token.getMorph()+ "<<<<<");

                ChatEntity chatEntity = chatRepository.findBySearch(token.getMorph()).orElseThrow(()->{
                    throw new IllegalArgumentException("찾는 값이 없습니다.");
                });

                result = chatEntity.getAnswer();
            }
        }
        return result;
    }

}
