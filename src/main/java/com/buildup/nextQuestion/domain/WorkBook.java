package com.buildup.nextQuestion.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Entity
@Getter @Setter
@Table(name = "work_book")
public class WorkBook {

    @Id @GeneratedValue
    @Column(name = "work_book_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "member_id")
    private Member member;

    private String name;

    private Timestamp recentSolveDate; // 문제집 최근 학습일

    @Column(name = "multiple_choice")
    private Integer multipleChoice = 0;

    private Integer ox = 0;

    @Column(name = "fill_in_the_blank")
    private Integer fillInTheBlank = 0;


}