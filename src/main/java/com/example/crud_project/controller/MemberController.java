package com.example.crud_project.controller;

import com.example.crud_project.domain.memberDto.DeleteDto;
import com.example.crud_project.domain.memberDto.ReadDto;
import com.example.crud_project.domain.memberDto.SignUpDto;
import com.example.crud_project.domain.memberDto.UpdateDto;
import com.example.crud_project.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/member")
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @PostMapping("/signUp")
    public void signUp(SignUpDto signUpDto) {
        memberService.signUp(signUpDto);
    }

    @PutMapping("/update")
    public void update(UpdateDto updateDto) {
        memberService.update(updateDto);
    }

    @GetMapping("")
    public ReadDto read(String identity) {
        return memberService.getMember(identity);
    }

    @DeleteMapping("/delete")
    public void delete(DeleteDto deleteDto) {
        memberService.delete(deleteDto);
    }
}
