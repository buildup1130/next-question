package com.buildup.nextQuestion.dto.solving;

import com.buildup.nextQuestion.domain.QuestionInfo;
import com.buildup.nextQuestion.domain.enums.SolvedType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FindHistoryByMemberResponse {
    private String encryptedHistoryId;
    private Timestamp solvedDate;
    private SolvedType solvedType;
    private List<QuestionInfoDTO> questionInfos;
}
