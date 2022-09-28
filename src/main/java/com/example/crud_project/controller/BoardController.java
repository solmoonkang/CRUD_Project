package com.example.crud_project.controller;

import com.example.crud_project.domain.entity.Board;
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
    public void register(Board board) {
        boardService.register(board);
    }

    // 게시글 수정
    @PutMapping("/updateBoard")
    public void update(Board board) {
        boardService.update(board);
    }

    // 게시글 목록
    // TODO return형식 뭐로 받아와야하는지 - service를 그대로 받아와야하는지
    @GetMapping("")
    public List<Board> list(Model model) {
        model.addAttribute("list", boardService.list());
        return boardService.list();
    }

    // 게시글 상세조회
    @GetMapping
    public void detail(Model model, Long id) {
        model.addAttribute("detail", boardService.detail(id));
        boardService.detail(id);
    }

    // 게시글 삭제
    @DeleteMapping("/deleteBoard")
    public void delete(Long id) {
        boardService.delete(id);    // id값(삭제할 게시글의 번호)이 들어오면 삭제 즉, 1번 id값이 들어오면 id=1인 게시글이 삭제
    }

}
