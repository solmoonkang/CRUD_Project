package com.example.crud_project.domain.memberDto;

import lombok.Getter;

@Getter
public class UpdateDto {
    private String identity;
    private String password;
    private String name;
    private String email;
    private String address;
    private String birthdate;
    private String sex;
    private String cellphone;
}
