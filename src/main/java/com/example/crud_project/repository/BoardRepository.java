package com.example.crud_project.repository;

import com.example.crud_project.domain.entity.Board;
import com.example.crud_project.domain.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepository  extends JpaRepository<Board, Long> {

    Board save(Board board);
}
