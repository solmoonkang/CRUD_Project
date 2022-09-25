package org.example.controller;

import com.example.crud_project.domain.memberDto.DeleteDto;
import com.example.crud_project.domain.memberDto.ReadDto;
import com.example.crud_project.domain.memberDto.SignUpDto;
import com.example.crud_project.domain.memberDto.UpdateDto;
import com.example.crud_project.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/member")
@RequiredArgsConstructor
public class MemberController {

    @Autowired
    MemberService memberService;

    // CRUD
    // C - POST
    // R - PUT
    // U - GET
    // D - DELETE

    // 회원 가입
    @PostMapping("/signUp")
    public void signUp(SignUpDto signUpDto) {
        memberService.signUp(signUpDto);
    }

    // 회원 정보 수정
    @PutMapping("/update")
    public void update(UpdateDto updateDto) {
        memberService.update(updateDto);
    }

    // 회원 정보 조회
    @GetMapping("")
    public ReadDto read(String identity) {
        return memberService.getMember(identity);
    }

    // 회원 정보 삭제
    @DeleteMapping("/delete")
    public void delete(DeleteDto deleteDto) {
        memberService.delete(deleteDto);
    }
}
