package com.buildup.nextQuestion.Service;

import com.buildup.nextQuestion.domain.WorkBook;
import com.buildup.nextQuestion.domain.enums.QuestionType;
import com.buildup.nextQuestion.dto.QuestionUpdateRequest;
import com.buildup.nextQuestion.Repository.QuestionRepository;
import com.buildup.nextQuestion.domain.Question;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.Local;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Service

public class QuestionService {

    @Autowired
    private QuestionRepository questionRepository;

    //생성된 문제 리스트 저장
    public void saveAll(JsonNode jsonNode) throws IOException {

        ObjectMapper objectMapper = new ObjectMapper();

        JsonNode questionsNode = jsonNode.get("questions");

        if (questionsNode != null && questionsNode.isArray( )) {
            List<Question> questions = objectMapper.readValue(
                    questionsNode.toString(),
                    new TypeReference<List<Question>>() {
                    }
            );
            questionRepository.saveAll(questions);
        }
    }

    //문제 제공(json형식 반환)
    public List<Question> findAllQuestionByWorkBook(WorkBook workbook){
        return questionRepository.findAllByWorkBook(workbook);
    }

    //문제 정보 갱신(update)
    public void updateQuestion (List<QuestionUpdateRequest> updatedQuestions) {
        for(QuestionUpdateRequest request : updatedQuestions) {
            Long questionId = request.getQuestionId();
           Question existingQuestion = questionRepository.findById(questionId).get(); //id로 Question객체 가져옴
            existingQuestion.setWrong(request.getWrong()); //객체 정답여부 update
            existingQuestion.setRecentSolveTime(request.getRecentSolveTime()); //객체 최근 시간 update

            questionRepository.save(existingQuestion); //객체 저장
        }
    }
}

