package com.dc.service;

import com.dc.entity.Member;
import com.dc.repository.CommentRepository;
import com.dc.repository.MemberRepository;
import com.dc.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberService {

    @Autowired
    private MemberRepository repository;

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private CommentRepository commentRepository;



    public int registerMember(Member member)
    {
        return repository.save(member) != null ? 1 : 0;
    }

    public int updateMember(Member member)
    {
        return repository.save(member) != null ? 1 : 0;
    }

    public List<Member> getMemberList()
    {
        return repository.findByAuthorities("USER");
    }

    public int withdrawalMemberByIdAndPassword(String id, String password)
    {

        commentRepository.deleteByWriterAndPassword(id, password);
        postRepository.deleteByWriterAndPassword(id,password);
        return repository.deleteByIdAndPassword(id,password);
    }

    public void withdrawalMemberByAdmin(Integer index)
    {
        repository.deleteById(index);
    }
}
