package com.example.crud_project.service;

import com.example.crud_project.domain.boardDto.BoardDto;
import com.example.crud_project.domain.entity.Board;
import com.example.crud_project.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardService {
    @Autowired
    private BoardRepository boardRepository;

    // TODO 게시글 등록
    public Long register(BoardDto boardDto) {
        // 게시글 작성

        return boardRepository.save(boardDto.toEntity()).getBno();
    }

    // TODO 게시글 수정
    public void update(Board board) {
        boardRepository.save(board);
    }

    // TODO 게시글 목록
    public List<BoardDto> list() {
        List<Board> boardList = boardRepository.findAll();
        List<BoardDto> boardDtoList = new ArrayList<>();

        for (Board board : boardList) {
            BoardDto boardDto = BoardDto.builder()
                    .title(board.getTitle())
                    .content(board.getContent())
                    .writer(board.getWriter())
                    .createdDate(board.getCreatedDate())
                    .updatedDate(board.getUpdatedDate())
                    .build();
            boardDtoList.add(boardDto);
        }
        return boardDtoList;
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
