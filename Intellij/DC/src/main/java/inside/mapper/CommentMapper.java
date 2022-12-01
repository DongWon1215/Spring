package inside.mapper;

import inside.domain.CommentDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CommentMapper {
    List<CommentDTO> selectPostAllComment(long postIndex);
    CommentDTO selectCommentByIndex(long commentIndex);

    int insertComment(CommentDTO commentDTO);
    int updateComment(long commentIndex, String commentPassword, String content);
    int deleteComment(long commentIndex);

}
