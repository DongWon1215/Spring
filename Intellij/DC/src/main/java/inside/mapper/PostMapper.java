package inside.mapper;

import inside.domain.PostDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PostMapper {

    List<PostDTO> selectAll();
    List<PostDTO> selectPage(int page, int limit);
    PostDTO selectByIndex (long postIndex);

    int insertPost(PostDTO postDTO);
    int updatePost(long postIndex, String postContent, String postPassword);
    int deletePost(long postIndex);
    int updatePostComment(long postIndex, long commentnum);
    int readPost(long postIndex);
}
