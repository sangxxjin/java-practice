package org.sangxxjin.javapractice.domain.member.member.service;

import java.util.Map;
import org.sangxxjin.javapractice.domain.member.member.entity.Member;
import org.sangxxjin.javapractice.standard.util.Ut;
import org.springframework.stereotype.Service;

@Service
public class AuthTokenService {

    public String genAccessToken(Member member) {
        long id = member.getId();
        String username = member.getUsername();
        return Ut.jwt.toString(
            "abcdefghijklmnopqrstuvwxyz1234567890abcdefghijklmnopqrstuvwxyz1234567890",
            60 * 60 * 24 * 365,
            Map.of("id", id, "username", username)
        );
    }

}