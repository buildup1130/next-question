package com.buildup.nextQuestion.service;

import com.buildup.nextQuestion.domain.LocalMember;
import com.buildup.nextQuestion.domain.Member;
import com.buildup.nextQuestion.dto.member.LoginRequest;
import com.buildup.nextQuestion.dto.member.LoginResponse;
import com.buildup.nextQuestion.repository.LocalMemberRepository;
import com.buildup.nextQuestion.utility.JwtUtility;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly=true)
@RequiredArgsConstructor
public class MemberService {

    private final LocalMemberRepository localMemberRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtility jwtUtility;

    public LoginResponse login(LoginRequest loginDTOrequest) {
        String userId = loginDTOrequest.getUserId();
        String password = loginDTOrequest.getPassword();
        // 1. userId로 회원 조회
        LocalMember localMember = localMemberRepository.findByUserId(userId).orElseThrow(() -> new IllegalArgumentException("아이디 또는 비밀번호가 올바르지 않습니다."));
        Member member = localMember.getMember();
        // 2. 비밀번호 검증
        if (!passwordEncoder.matches(password, localMember.getPassword())) {
            throw new IllegalArgumentException("아이디 또는 비밀번호가 올바르지 않습니다.");
        }
        LoginResponse loginDTOresponse = new LoginResponse(jwtUtility.generateToken(userId, member.getRole()),member.getNickname(), member.getRole());
        // 3. JWT 토큰 생성 후 반환
        return loginDTOresponse;
    }
}
