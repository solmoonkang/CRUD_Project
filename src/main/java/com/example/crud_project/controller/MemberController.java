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

    // @RequestBody - HTTP로 받은 요청의 body 부분을 통채로 전달
    @PostMapping("/signUp")
    public void signUp(@RequestBody SignUpDto signUpDto) {
        memberService.signUp(signUpDto);
    }

    @PutMapping("/update")
    public void update(@RequestBody UpdateDto updateDto) {
        memberService.update(updateDto);
    }

    // @RequestParam - URL에서 파라미터 추출
    @GetMapping("") // URL에 파라미터의 값과 이름을 함께 전달(노출)
    public ReadDto read(@RequestParam("identity") String identity) {
        return memberService.getMember(identity);
    }

    @DeleteMapping("/delete")
    public void delete(DeleteDto deleteDto) {
        memberService.delete(deleteDto);
    }
}
