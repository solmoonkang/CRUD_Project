package com.example.crud_project.domain.memberDto;

import lombok.Getter;

@Getter
// 회원가입
public class SignUpDto {
    private String identity;
    private String password;
    private String name;
    private String email;
    private String address;
    private String birthdate;
    private String sex;
    private String phonenumber;
}
