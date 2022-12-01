package inside.mapper;

import inside.domain.PostDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PostMapper {

    List<PostDTO> selectAll();
    PostDTO selectByIndex (long postIndex);

    int insertPost(PostDTO postDTO);
    int updatePost(long postIndex, String postTitle, String postContent, String postPassword);
    int deletePost(long postIndex);
}
