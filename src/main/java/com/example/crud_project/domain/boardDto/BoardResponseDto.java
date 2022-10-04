package com.example.crud_project.domain.boardDto;

import com.example.crud_project.domain.entity.Board;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
// 게시글 응
public class BoardResponseDto {
    private Long bno;
    private String title;
    private String content;
    private String writer;
    private int hits;
    private String registerId;
    private LocalDateTime createdDate;

    public BoardResponseDto(Board entity) {
        this.bno = entity.getBno();
        this.title = entity.getTitle();
        this.content = entity.getContent();
        this.writer = entity.getWriter();
        this.hits = entity.getHits();
        this.registerId = entity.getRegisterId();
        this.createdDate = entity.getCreatedDate();
    }
}
