package com.app.board.mapper;

import com.app.board.Domain.ReplyDTO;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ReplyMapper {

    @Select("select * from tbl_reply where bno = #{bno}")
    List<ReplyDTO> selectALl(int bno);

    @Select("select * from tbl_reply where rno = #{rno}")
    ReplyDTO selectByRno(int rno) ;

    @Insert("insert into tbl_reply(bno,reply,replyer) values(#{bno},#{reply},#{replyer})")
    @Options(useGeneratedKeys = true, keyProperty = "rno", keyColumn = "rno")         //useGeneratedKeys : 자동으로 생성되는 값, ketProperty : insert 된 키 값
    int insertReply(ReplyDTO replyDTO);

}
