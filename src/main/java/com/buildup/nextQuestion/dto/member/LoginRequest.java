package com.buildup.nextQuestion.dto.member;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoginRequest {
    private String userId;
    private String password;
    private boolean KeepLogin;
}
