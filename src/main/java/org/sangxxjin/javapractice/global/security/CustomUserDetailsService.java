package org.sangxxjin.javapractice.global.security;


import java.util.List;
import lombok.RequiredArgsConstructor;
import org.sangxxjin.javapractice.domain.member.member.entity.Member;
import org.sangxxjin.javapractice.domain.member.member.repository.MemberRepository;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {
    private final MemberRepository memberRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Member member = memberRepository.findByUsername(username)
            .orElseThrow(() -> new UsernameNotFoundException("사용자를 찾을 수 없습니다."));

        return new User(
            member.getUsername(),
            member.getPassword(),
            List.of()
        );
    }
}
