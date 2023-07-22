package com.example.demo.admin.member.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum MemberRole {
    USER("ROLE_USER"), ADMIN("ROLE_ADMIN");
    private String value;
}
