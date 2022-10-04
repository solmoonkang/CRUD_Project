package com.example.crud_project.repository;

import com.example.crud_project.domain.boardDto.BoardRequestDto;
import com.example.crud_project.domain.entity.Board;
import com.example.crud_project.domain.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface BoardRepository  extends JpaRepository<Board, Long> {

    @Transactional
    @Modifying
    @Query
    public int updateBoard(BoardRequestDto boardRequestDto);

    Board save(Board board);
}
