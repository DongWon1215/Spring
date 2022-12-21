package com.app.board;

import com.app.board.Domain.BoardMember;
import com.app.board.Repository.BoardMemberRepository;
import com.app.board.Repository.BoardRepository;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.time.LocalDateTime;

@SpringBootTest
@Log4j2
public class BoardMemberRepositoryTest {

    @Autowired
    private BoardMemberRepository boardMemberRepository;

    @Autowired
    private PasswordEncoder encoder;
    @Autowired
    private BoardRepository boardRepository;

    @Test
    public void saveTest()
    {
        BoardMember boardMember = BoardMember.builder().userid("cool").username("tester").password(encoder.encode("1234")).role("USER").regdate(LocalDateTime.now()).build();

        BoardMember member = boardMemberRepository.save(boardMember);

        log.info(member);
    }


}
