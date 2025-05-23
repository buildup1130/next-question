package com.buildup.nextQuestion.dto.workBook;

import com.buildup.nextQuestion.domain.enums.QuestionType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetQuestionsByWorkBookResponse {
    private String encryptedQuestionId;
    private String EncryptedQuestionInfoId;
    private String name;
    private QuestionType type;
    private String answer;
    private String opt;
    private Timestamp createTime;
    private Timestamp recentSolveTime;
}
