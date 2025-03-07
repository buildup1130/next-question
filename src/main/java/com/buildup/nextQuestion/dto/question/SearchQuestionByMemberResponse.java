package com.buildup.nextQuestion.dto.question;

import com.buildup.nextQuestion.domain.enums.QuestionType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.time.LocalTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SearchQuestionByMemberResponse {
    private String encryptedQuestionId;
    private String name;
    private QuestionType type;
    private String answer;
    private String opt;
    private Timestamp createTime;
    private Timestamp recentSolveTime;

}
