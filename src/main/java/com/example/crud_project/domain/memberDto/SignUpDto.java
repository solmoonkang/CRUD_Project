package com.example.crud_project.domain.memberDto;

import lombok.Getter;

// @Setter - Entity 클래스는 테이블 그 자체
// 이는 각각의 멤버 변수는 해당 테이블의 컬럼이라는 의미
// 컬럼에 대한 Setter를 생성하는 경우, 객체의 값이 어느 시점에서 변경되었는 알 수 없음
// 따라서 Entity 클래스에는 Setter 메소드가 존재해선 안됨
@Getter
// 회원가입
public class SignUpDto {
    private String identity;
    private String password;
    private String name;
}
