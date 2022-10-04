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

    // TODO Message, File Upload, Pagging, Search Function
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bno;
    // TODO 게시판에 등록된 게시물의 번호를 저장 -> 번호로 게시물을 등록/수정/삭제할 수 있는 형태로
    private Long id;

    // TODO Secret Answer Function
    @Column(length = 10, nullable = false)
    private String title;   // 제목
    @Column(length = 100, nullable = false)
    private String content; // 내용
    @Column(columnDefinition = "TEXT", nullable = false)
    private String writer;  // 작성자
    private String registerId;  // 작성 번호
    private int hits;       // 방문수
    //    private String noticeYn;  // 공지 여부
    //    private String secretYn;  // 비밀 여부
    // private String deleteYn;  // 삭제 여부

    @CreationTimestamp  // INSERT쿼리가 발생할 경우, 현재 시간을 값으로 채워 쿼리를 생성
    private LocalDateTime createdDate;  // 작성일

    @UpdateTimestamp    // UPDATE쿼리가 발생한 경우, 수정이 발생할 때마다 마지막 수정시간을 업데이트함
    private LocalDateTime modifiedDate;  // 수정일

    @ManyToOne
    private Member member;

    @Builder
    public Board(String title, String content, String writer, String registerId, int hits) {
        this.title = title;
        this.content = content;
        this.writer = writer;
        this.registerId = registerId;
        this.hits = hits;
    }

    public void update(String title, String content, String writer) {
        this.title = title;
        this.content = content;
        this.writer = writer;
        this.modifiedDate = LocalDateTime.now();
    }
}
