package com.example.crud_project.domain.boardDto;

import com.example.crud_project.domain.entity.Board;
import lombok.*;

import java.time.LocalDateTime;

@Getter @Setter
@ToString
@NoArgsConstructor
public class BoardDto {
    private String title;
    private String content;
    private String writer;

    private LocalDateTime createdDate;
    private LocalDateTime updatedDate;

    // TODO toEntity() 부분 수정필요
    public Board toEntity() {
        Board board = Board.builder()

        return board;
    }

    @Builder
    public BoardDto(String title, String content, String writer, LocalDateTime createdDate, LocalDateTime updatedDate) {
        this.title = title;
        this.content = content;
        this.writer = writer;
        this.createdDate = createdDate;
        this.updatedDate = updatedDate;
    }
}
