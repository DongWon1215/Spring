package com.app.board.mapper;

import com.app.board.Domain.BoardDTO;
import org.apache.ibatis.annotations.*;

import java.sql.SQLException;
import java.util.List;

@Mapper
public interface BoardMapper {

    @Select("select * from tbl_board")
    List<BoardDTO> selectAll();

    @Select("select * from tbl_board order by bno desc limit #{start},#{count}")
    List<BoardDTO> selectList(@Param("start") int start, @Param("count") int count);


    @Select("select count(*) from tbl_board")
    Integer totalCount();

    @Insert("insert into tbl_board (title, content, writer, photo) values (#{title},#{writer},#{content},#{photo})")
    Integer insert(BoardDTO boardDTO) throws SQLException;

    @Select("select * from tbl_board where bno = #{bno}")
    BoardDTO selectByBno(int bno);

    @Delete("delete from tbl_board where bno = #{bno}")
    Integer deleteByBno(int bno);

    @Update("update tbl_board set title = #{title}, content= #{content} ,photo = #{photo}, updatedate = now()  where bno = #{bno}")
    Integer update(BoardDTO boardDTO) throws SQLException;
}
