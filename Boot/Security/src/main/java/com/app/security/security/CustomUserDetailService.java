package com.app.security.security;

import com.app.security.entity.Member;
import com.app.security.entity.MemberRole;
import com.app.security.repository.AuthMemberDTO;
import com.app.security.repository.MemberRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Log4j2
public class CustomUserDetailService implements UserDetailsService {

    @Autowired
    private MemberRepository memberRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        log.info("username is >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>"+username);


        Optional<Member> result = memberRepository.findById(username);

        if(result.isEmpty())
        {
            throw new UsernameNotFoundException(("Check User Email"));
        }

        Member member = result.get();

        log.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>" + member);

        List<SimpleGrantedAuthority> authorities = new ArrayList<>();

        for(MemberRole memberRole : member.getRoleSet())
        {
            authorities.add(new SimpleGrantedAuthority("ROLE_" + memberRole.name()));
        }

        AuthMemberDTO authMemberDTO = new AuthMemberDTO(member.getEmail(),member.getPassword(),authorities,member.getName());

        return authMemberDTO;
    }
}
