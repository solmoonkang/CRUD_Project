package com.example.crud_project.domain.memberDto;

import lombok.Builder;
import lombok.Getter;

@Getter
// 회원정보 조회
public class ReadDto {

    private String identity;
    private String password;
    private String name;

    @Builder
    public ReadDto(String identity, String password, String name) {
        this.identity = identity;
        this.password = password;
        this.name = name;
    }
}
