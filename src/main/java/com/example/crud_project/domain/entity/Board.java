package com.example.crud_project.domain.entity;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import javax.persistence.Id;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter @Setter
@Entity @Table
@AllArgsConstructor
@NoArgsConstructor
public class Board {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bno;

    @Column(length = 10, nullable = false)
    private String title;   // 제목
    @Column(length = 100, nullable = false)
    private String content; // 내용
    @Column(columnDefinition = "TEXT", nullable = false)
    private String writer;  // 작성자
    private int view;       // 방문수
    private String notice;  // 공지 여부
    private String secret;  // 비밀 여부
    private String delete;  // 삭제 여부

    @CreationTimestamp  // INSERT쿼리가 발생할 경우, 현재 시간을 값으로 채워 쿼리를 생성
    private LocalDateTime createdDate;  // 작성일

    @UpdateTimestamp    // UPDATE쿼리가 발생한 경우, 수정이 발생할 때마다 마지막 수정시간을 업데이트함
    private LocalDateTime updatedDate;  // 수정일

    @ManyToOne
    private Member member;

    @Builder
    public Board(String title, String content, String writer) {
        this.title = title;
        this.content = content;
        this.writer = writer;
    }
}
