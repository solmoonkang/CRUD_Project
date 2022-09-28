package com.example.crud_project.domain.memberDto;

import lombok.Getter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

// @Setter - Entity 클래스는 테이블 그 자체
// 이는 각각의 멤버 변수는 해당 테이블의 컬럼이라는 의미
// 컬럼에 대한 Setter를 생성하는 경우, 객체의 값이 어느 시점에서 변경되었는 알 수 없음
// 따라서 Entity 클래스에는 Setter 메소드가 존재해선 안됨
@Getter
// 회원가입
public class SignUpDto {

    // validation이 지원하는 Annotation들로 회원가입 시 간단한 유효성 검사들을 처리
    /*
        1. @NotBlank - 닉네임 입력폼이 비어있는 상태로 요청을 보낼 경우 해당 에러메시지가 나타남
        2. @Size - 지정된 사이즈에서 벗어나는 값을 입력할 경우 에러메시지가 나타남
        3. @Email - 이메일 형태만 입력이 가능함
        4. @Pattern - 지정된 패턴만 입력하게 하여 휴대폰 번호 폼에서 이상한 값들이 요청되는 것을 방지함
     */
    // 해당 로직을 실행할 경우 아이디/이메일/휴대폰번호가 중복되는 경우 true, 중복되지 않을 경우 false가 리턴
    // 따라서 리턴되는 값에 따라 FRONT개발 시 알맞게 처리하면 간단한 중복검사를 진행가능

    @NotBlank(message = "아이디를 입력해주세요")
    @Size(min = 2, max = 10, message = "아이디는 2자 이상 10자 이하로 입력해주세요")
    private String identity;

    @NotBlank(message = "비밀번호를 입력해주세요")
    @Size(min = 8, max = 20, message = "비밀번호는 8자 이상 20자 이하로 입력해주세요")
    private String password;

    @NotBlank(message = "이메일 주소를 입력해주세요")
    @Email(message = "올바른 이메일 주소를 입력해주세요")
    private String email;

    @NotBlank(message = "아이디를 입력해주세요")
    @Pattern(regexp = "(01[016789])(\\d{3,4})(\\d{4})", message = "올바른 휴대폰 번호를 입력해주세요")
    private String cellphone;

    // 이름
    private String name;
    // 주소
    private String address;
    // 생년월일(19980521)
    private String birthdate;
    // 성별
    private String sex;
}
