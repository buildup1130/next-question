package com.buildup.nextQuestion.controller;


import com.buildup.nextQuestion.domain.LocalMember;
import com.buildup.nextQuestion.dto.member.FindMembersResponse;
import com.buildup.nextQuestion.dto.member.LoginRequest;
import com.buildup.nextQuestion.dto.member.LoginResponse;
import com.buildup.nextQuestion.dto.member.RegistRequest;
import com.buildup.nextQuestion.service.LocalMemberService;
import com.buildup.nextQuestion.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequiredArgsConstructor
public class MemberController {

    private final LocalMemberService localMemberService;
    private final MemberService memberService;

    @PostMapping("public/member/regist")
    public ResponseEntity<String> register(@RequestBody RegistRequest registDTORequest) {
            LocalMember localMember = localMemberService.register(registDTORequest);
            return ResponseEntity.status(HttpStatus.CREATED).body("회원가입에 성공했습니다.");
    }

    @PostMapping("public/member/login/local")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginDTOrequest) {
            LoginResponse response = memberService.login(loginDTOrequest);
            return ResponseEntity.ok(response);
    }

    @GetMapping("public/members/search")
    public ResponseEntity<?> findAllMember (
            @RequestHeader("Authorization") String token) throws Exception {
            List<FindMembersResponse> response = memberService.findMembers();
            return ResponseEntity.ok(response);
    }


}

