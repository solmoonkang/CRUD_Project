package com.example.crud_project.domain.boardDto;

import com.example.crud_project.domain.entity.Board;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter @Setter
@NoArgsConstructor
// 게시글 요청
public class BoardRequestDto {
    private Long bno;
    private String title;
    private String content;
    private String writer;
    private String registerId;

    public Board toEntity() {
        return Board.builder()
                .title(title)
                .content(content)
                .writer(writer)
                .registerId(registerId)
                .build();
    }
}
