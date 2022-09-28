package com.example.crud_project.domain.entity;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.Id;

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

    private String title;
    private String content;
    private String writer;

    @CreationTimestamp  // INSERT쿼리가 발생할 경우, 현재 시간을 값으로 채워 쿼리를 생성
    private LocalDateTime createdDate = LocalDateTime.now();

    @UpdateTimestamp    // UPDATE쿼리가 발생한 경우, 수정이 발생할 때마다 마지막 수정시간을 업데이트함
    private LocalDateTime updatedDate = LocalDateTime.now();

    @ManyToOne
    private Member member;

}
