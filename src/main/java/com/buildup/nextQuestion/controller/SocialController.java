package com.buildup.nextQuestion.controller;

import com.buildup.nextQuestion.dto.google.AuthRequest;
import com.buildup.nextQuestion.dto.member.LoginResponse;
import com.buildup.nextQuestion.dto.member.SocialRegistRequest;
import com.buildup.nextQuestion.repository.SocialMemberRepository;
import com.buildup.nextQuestion.service.SocialMemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequiredArgsConstructor
public class SocialController {

    private final SocialMemberRepository socialMemberRepository;
    private final SocialMemberService socialMemberService;

    //구글 로그인 페이지 반환
    @PostMapping("public/oauth2/google")
    public String postGooglePage() {
        String reqUrl = socialMemberService.loginUrlGoogle();
        return reqUrl;
    }

    // 구글 인증 후 받은 authCode를 처리하는 엔드포인트
    @PostMapping("public/oauth2/google/callback")
    public ResponseEntity<?> login(@RequestBody AuthRequest authRequest) throws Exception {
        String authCode = socialMemberService.decodeCode(authRequest.getCode());
        String snsId = socialMemberService.authGoogle(authCode);  // authCode로 snsId 추출
        if (socialMemberRepository.existsBySnsId(snsId)) {
            LoginResponse response = socialMemberService.loginGoogle(snsId, authRequest.isKeepLogin());
            return ResponseEntity.ok(response);  // 로그인 응답 반환
        } else {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(Map.of("snsId", snsId, "error", "아아디가 존재하지 않습니다. 회원가입을 진행해 주세요."));
        }
    }

    @PostMapping("public/member/regist/social/google")
    public ResponseEntity<?> register(@RequestBody SocialRegistRequest registDTORequest) {
        socialMemberService.registerGoogle(registDTORequest);
        return ResponseEntity.status(HttpStatus.CREATED).body("회원가입에 성공했습니다.");
    }
}
