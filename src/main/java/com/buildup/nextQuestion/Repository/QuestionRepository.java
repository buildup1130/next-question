package com.buildup.nextQuestion.Repository;

import com.buildup.nextQuestion.domain.Question;
import com.buildup.nextQuestion.domain.WorkBook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Long> {

    List<Question> findAllByWorkBook(WorkBook workBook);

}