package com.example.crud_project.domain.entity;

import lombok.*;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import javax.persistence.*;

import static javax.persistence.GenerationType.*;

@Getter @Setter
@Entity
@Table
@AllArgsConstructor
@NoArgsConstructor
public class Member {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long mno;

    private String identity;
    private String password;
    private String name;
    private String email;
    private String address;
    private String birthdate;
    private String sex;
    private String cellphone;

    @Builder
    public Member(String identity, String password, String name) {
        this.identity = identity;
        this.password = password;
        this.name = name;
    }

    @Builder
    public void updateMember(String email, String address, String birthdate, String sex, String cellphone) {
        this.email = email;
        this.address = address;
        this.birthdate = birthdate;
        this.sex = sex;
        this.cellphone = cellphone;
    }
}
