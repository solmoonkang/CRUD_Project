package com.example.crud_project.service;

import com.example.crud_project.domain.entity.Board;
import com.example.crud_project.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardService {
    @Autowired
    private BoardRepository boardRepository;

    // TODO 게시글 등록
    public void register(Board board) {
        // 게시글 작성
        boardRepository.save(board);
    }

    // TODO 게시글 수정
    public void update(Board board) {
        boardRepository.save(board);
    }

    // TODO 게시글 목록
    public List<Board> list() {
        return boardRepository.findAll();
    }

    // TODO 게시글 상세조회
    public Board detail(Long id) {
        return boardRepository.findById(id).get();
    }

    // TODO 게시글 삭제
    public void delete(Long id) {
        boardRepository.deleteById(id);
    }

}
