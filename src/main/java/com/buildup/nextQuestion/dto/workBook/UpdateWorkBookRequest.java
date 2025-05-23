package com.buildup.nextQuestion.dto.workBook;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateWorkBookRequest {
    private String encryptedWorkBookId;
    private String name;
}
