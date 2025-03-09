package com.buildup.nextQuestion.dto.solving;

import com.buildup.nextQuestion.domain.enums.SolvedType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SaveHistoryByNormalExamRequest {
    private SolvedType type;
    private List<NormalExamInfoDTO> info;

}
