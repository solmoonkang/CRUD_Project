package com.example.crud_project.domain.entity;

import lombok.*;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import javax.persistence.*;

import static javax.persistence.GenerationType.*;

@Getter @Setter
@Entity // 해당 클래스가 테이블과 매핑되는 JPA의 Entity 클래스를 의미
@Table
@AllArgsConstructor
@NoArgsConstructor  // 해당 클래스의 기본 생성자를 생성
public class Member {

    @Id // 해당 멤버가 Entity의 PK임을 의미
    @GeneratedValue(strategy = GenerationType.IDENTITY) // JPA에서 Entity의 PrimaryKey를 생성
    private Long mno;

    private String identity;
    private String password;
    private String name;
    private String email;
    private String address;
    private String birthdate;
    private String sex;
    private String cellphone;

    @Builder    // 생성자 대신에 이용하는 패턴
    public Member(String identity, String password, String name) {
        this.identity = identity;
        this.password = password;
        this.name = name;
    }

    public void updateMember(String email, String address, String birthdate, String sex, String cellphone) {
        this.email = email;
        this.address = address;
        this.birthdate = birthdate;
        this.sex = sex;
        this.cellphone = cellphone;
    }
}
