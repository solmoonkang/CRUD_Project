package com.example.crud_project.service;

import com.example.crud_project.domain.boardDto.BoardDto;
import com.example.crud_project.domain.entity.Board;
import com.example.crud_project.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BoardService {
    @Autowired
    private BoardRepository boardRepository;

    // TODO 게시글 등록
    public void register(BoardDto boardDto) {
        boardRepository.save(boardDto.toEntity());
    }

    // TODO 게시글 수정
    // TODO 영속성 컨텍스트 - Entity를 영구히 저장하는 환경 -> 추가적으로 공부
    public void update(Board board) {


        boardRepository.save();
    }

    // TODO 게시글 목록
    // 이 부분 이해가 잘 안됌 -> 검색해서 공부
    public void list() {

    }

    // TODO 게시글 상세조회
    public void detail() {

    }

    // TODO 게시글 삭제
    public void delete() {

    }

}
