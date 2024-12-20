package com.buildup.nextQuestion.domain;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter@Setter
@Table(name = "work_book")
public class WorkBook {

    @Id@GeneratedValue
    @Column(name="work_book_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    private Question question;
}
