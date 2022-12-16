package com.app.security;

import com.app.security.entity.Member;
import com.app.security.entity.MemberRole;
import com.app.security.repository.MemberRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.HashSet;

@SpringBootTest
public class MemberRepositoryTest {

    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Test
    public void insertMember()
    {
        Member member = Member.builder().email("test1@gmail.com").name("사용자1").password(passwordEncoder.encode("1111")).roleSet(new HashSet<MemberRole>()).build();

        member.addMemberRole(MemberRole.USER);

        memberRepository.save(member);
    }
}
