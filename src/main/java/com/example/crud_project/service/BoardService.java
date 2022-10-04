package com.example.crud_project.service;

import com.example.crud_project.domain.boardDto.BoardRequestDto;
import com.example.crud_project.domain.boardDto.BoardResponseDto;
import com.example.crud_project.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BoardService {
    @Autowired
    private BoardRepository boardRepository;

    // TODO 게시글 등록
    @Transactional
    public Long register(BoardRequestDto boardRegisteDto) {
        return boardRepository.save(boardRegisteDto.toEntity()).getId();
    }

    // TODO 게시글 수정
    // TODO 영속성 컨텍스트 - Entity를 영구히 저장하는 환경 -> 추가적으로 공부
    public int update(BoardRequestDto boardRequestDto) {
        return boardRepository.updateBoard(boardRequestDto);
    }

    // TODO 게시글 목록
    @Transactional(readOnly = true)
    public List<BoardResponseDto> list() {
        return boardRepository.findAll().stream()
                .map(BoardResponseDto::new).collect(Collectors.toList());
    }

    // TODO 게시글 상세조회
    public BoardResponseDto detail(Long bno) {
        return new BoardResponseDto(boardRepository.findById(bno).get());
    }

    // TODO 게시글 삭제
    public void delete(Long bno) {
        boardRepository.deleteById(bno);
    }

}
