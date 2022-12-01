package inside.service;

import inside.domain.PostDTO;
import inside.mapper.PostMapper;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Log4j2
public class PostService {
    @Autowired(required = false)
    PostMapper PostMapper;

    public List<PostDTO> getPostAll()
    {
        List<PostDTO> list = new ArrayList<>();

        list = PostMapper.selectAll();

        return list;
    }
    public PostDTO getPostByIndex(long index)
    {
        PostDTO PostDTO = null;

        PostDTO = PostMapper.selectByIndex(index);

        return PostDTO;
    }

    public boolean insertPost(PostDTO PostDTO)
    {
        if(PostMapper.insertPost(PostDTO) != 0)
            return true;

        return false;
    }
    public boolean updatePost(long index,String title,String password, String content)
    {
        if(PostMapper.updatePost(index,title,password,content) != 0)
            return true;

        return false;
    }
    public boolean deletePost(long index)
    {
        if(PostMapper.deletePost(index) != 0)
            return true;

        return false;
    }

}
