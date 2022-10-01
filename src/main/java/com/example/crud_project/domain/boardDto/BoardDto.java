package com.example.crud_project.domain.boardDto;

import com.example.crud_project.domain.entity.Board;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@ToString
@NoArgsConstructor
public class BoardDto {
    private String title;
    private String content;
    private String writer;
    int hits;
    private String deletedYn;
    private LocalDateTime createdDate;
    private LocalDateTime modifiedDate;

    public Board toEntity() {
        return Board.builder()
                .title(title)
                .content(content)
                .writer(writer)
                .hits(0)
                .deleteYn(deletedYn)
                .build();
    }

    @Builder
    public BoardDto(String title, String content, String writer, int hits, String deletedYn, LocalDateTime createdDate, LocalDateTime updatedDate) {
        this.title = title;
        this.content = content;
        this.writer = writer;
        this.hits = hits;
        this.deletedYn = deletedYn;
        this.createdDate = createdDate;
        this.modifiedDate = updatedDate;
    }
}
