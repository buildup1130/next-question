package com.buildup.nextQuestion.domain;

import com.buildup.nextQuestion.domain.enums.SolvedType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Entity
@Getter@Setter
public class History {

    @Id@GeneratedValue
    @Column(name = "history_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    private Timestamp solvedDate;

    private SolvedType type;
}
