package com.example.demo.base.chat.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString
@Table(name = "chat")
public class ChatEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name= "search", nullable = false, unique = true)
    private String search;

    @Column(name="answer", nullable = false)
    private String answer;
}
