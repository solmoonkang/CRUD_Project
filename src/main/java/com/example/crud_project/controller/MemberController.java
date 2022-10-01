package com.example.crud_project.controller;

import com.example.crud_project.domain.entity.Member;
import com.example.crud_project.domain.memberDto.DeleteDto;
import com.example.crud_project.domain.memberDto.ReadDto;
import com.example.crud_project.domain.memberDto.SignUpDto;
import com.example.crud_project.domain.memberDto.UpdateDto;
import com.example.crud_project.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/member")
@RequiredArgsConstructor
public class MemberController {

    @Autowired
    private MemberService memberService;

    // 회원 가입
    // @RequestBody - HTTP로 받은 요청의 body 부분을 통채로 전달
    @PostMapping("/signUp")
    public void signUp(@RequestBody SignUpDto signUpDto) {
        memberService.signUp(signUpDto);
    }

    // TODO CheckDuplicate URL Site
    // 회원 가입 시 중복 확인
    // 아이디 중복 확인
    @GetMapping("")
    public ResponseEntity<Boolean> checkIdentityDuplicate(@PathVariable String identity) {
        return ResponseEntity.ok(memberService.checkIdentityDuplicate(identity));
    }

    // 이메일 중복 확인
    @GetMapping("")
    public ResponseEntity<Boolean> checkEmailDuplicate(@PathVariable String email) {
        return ResponseEntity.ok(memberService.checkEmailDuplicate(email));
    }

    // 핸드폰 번호 중복 확인
    @GetMapping("")
    public ResponseEntity<Boolean> checkCellphoneDuplicate(@PathVariable String cellphone) {
        return ResponseEntity.ok(memberService.checkCellphoneDuplicate(cellphone));
    }

    // 회원 정보 수정
    @PutMapping("/update")
    public void update(@RequestBody UpdateDto updateDto) {
        memberService.update(updateDto);
    }

    // 회원 정보 조회
    // @RequestParam - URL에서 파라미터 추출
    @GetMapping("") // URL에 파라미터의 값과 이름을 함께 전달(노출)
    public ReadDto read(@RequestParam("identity") String identity) {
        return memberService.getMember(identity);
    }

    // 전체 회원 정보 조회
    @GetMapping("")
    public List<Member> getAllMember() {
        return memberService.getAllMember();
    }

    // 회원 정보 삭제
    @DeleteMapping("/delete")
    public void delete(DeleteDto deleteDto) {
        memberService.delete(deleteDto);
    }
}
