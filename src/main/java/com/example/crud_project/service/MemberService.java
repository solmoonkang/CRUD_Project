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

@Service
@RequiredArgsConstructor
@Transactional
public class MemberService {
    @Autowired
    MemberRepository memberRepository;

    // 회원 가입
    public void signUp(SignUpDto signUpDto) {



        Member member = Member.builder()
                .identity(signUpDto.getIdentity())
                .password(signUpDto.getPassword())
                .name(signUpDto.getName())
                .email(signUpDto.getEmail())
                .address(signUpDto.getAddress())
                .birthdate(signUpDto.getBirthdate())
                .sex(signUpDto.getSex())
                .phonenumber(signUpDto.getPhonenumber())
                .build();

        memberRepository.save(member);
    }

    // 회원 정보 수정
    public void update(UpdateDto updateDto) {
        Member member = memberRepository.findByIdentity(updateDto.getIdentity());
        memberRepository.save(member);
    }

    // 전체 회원 정보 조회
    // public List<ReadDto> getAllMember() {
    //
    // }

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
