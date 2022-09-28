package com.example.crud_project.service;

import com.example.crud_project.domain.entity.Member;
import com.example.crud_project.domain.memberDto.DeleteDto;
import com.example.crud_project.domain.memberDto.ReadDto;
import com.example.crud_project.domain.memberDto.SignUpDto;
import com.example.crud_project.domain.memberDto.UpdateDto;
import com.example.crud_project.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/*
스프링에서의 빈이란
-   스프링은 경량 컨테이너로 객체 생성, 소멸과 같은 life cycle을 관리하며 스프링 컨테이너로부터 필요한 객체를 얻음
    스프링 컨테이너에 의해 자바 객체가 만들어지게 되면 이 객체를 스프링은 스프링 빈(BEAN)이라고 부름
스프링 빈의 어노테이션 종류
-   @Component, @Service, @Controller, @Repository, @Bean, @Configuration 등이 존재
 */

@Service
@RequiredArgsConstructor
@Transactional
public class MemberService {
    @Autowired
    private MemberRepository memberRepository;

    // 회원 가입
    public void signUp(SignUpDto signUpDto) {
        Member member = Member.builder()
                .identity(signUpDto.getIdentity())
                .password(signUpDto.getPassword())
                .name(signUpDto.getName())
                .build();

        memberRepository.save(member);
    }

    // 회원 가입 시 중복 여부 확인
    // 아이디 중복 확인
    public boolean checkIdentityDuplicate(String identity) {
        return memberRepository.existsByIdentity(identity);
    }

    // 이메일 중복 확인
    public boolean checkEmailDuplicate(String email) {
        return memberRepository.existsByEmail(email);
    }

    // 핸드폰 번호 중복 확인
    public boolean checkCellphoneDuplicate(String cellphone) {
        return memberRepository.existsByCellphone(cellphone);
    }

    // 회원 정보 수정
    public void update(UpdateDto updateDto) {
        Member member = memberRepository.findByIdentity(updateDto.getIdentity());

//        if(updateDto.getIdentity().equals(null)) {
//            System.out.println("아이디가 입력되지 않았습니다!");
//        } else if (updateDto.getPassword().equals(null)) {
//            System.out.println("비밀번호가 입력되지 않았습니다!");
//        }

//        member.updateName(updateDto.getName()); // -> 홍길동에서 홍준표로 바뀌는 부분
        // email, address, birthdate, sex, phonenumber를 수정
        member.updateMember(updateDto.getEmail(), updateDto.getAddress(), updateDto.getBirthdate(), updateDto.getSex(), updateDto.getCellphone());
        memberRepository.save(member);
    }

    // 전체 회원 정보 조회
     public List<Member> getAllMember() {
        return memberRepository.findAll();
     }

    // 회원 정보 조회
    public ReadDto getMember(String identity) {
        Member member = memberRepository.findByIdentity(identity);

        ReadDto readDto = ReadDto.builder()
                .identity(member.getIdentity())
                .build();
        return readDto;
    }

    // 회원 정보 삭제
    public void delete(DeleteDto deleteDto) {
        Member member = memberRepository.findByIdentity(deleteDto.getIdentity());
        memberRepository.delete(member);
    }
}
