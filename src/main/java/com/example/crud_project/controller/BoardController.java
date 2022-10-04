package com.example.crud_project.controller;

import com.example.crud_project.domain.boardDto.BoardRequestDto;
import com.example.crud_project.domain.boardDto.BoardResponseDto;
import com.example.crud_project.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/board")
@RequiredArgsConstructor
public class BoardController {
    @Autowired
    private BoardService boardService;

    // 게시글 등록
    @PostMapping("/register")
    public void register(BoardRequestDto boardRequestDto) {
        boardService.register(boardRequestDto);
    }

    // 게시글 수정
    @PutMapping("/updateBoard")
    public int update(BoardRequestDto boardRequestDto) {
        return boardService.update(boardRequestDto);
    }

    // 게시글 목록
    // TODO return형식 뭐로 받아와야하는지 - service를 그대로 받아와야하는지
    @GetMapping("")
    public List<BoardResponseDto> list(Model model) {
        model.addAttribute("list", boardService.list());
        return boardService.list();
    }

    // 게시글 상세조회
    @GetMapping
    public void detail(Model model, Long bno) {
        model.addAttribute("detail", boardService.detail(bno));
        boardService.detail(bno);
    }

    // 게시글 삭제
    @DeleteMapping("/deleteBoard")
    public void delete(Long bno) {
        boardService.delete(bno);    // id값(삭제할 게시글의 번호)이 들어오면 삭제 즉, 1번 id값이 들어오면 id=1인 게시글이 삭제
    }

}
