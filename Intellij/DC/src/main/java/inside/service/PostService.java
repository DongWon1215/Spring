package inside.service;

import inside.domain.PostDTO;
import inside.mapper.PostMapper;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
@Log4j2
public class PostService {
    @Autowired(required = false)
    PostMapper postMapper;

    public List<PostDTO> getPostAll()
    {
        List<PostDTO> list = new ArrayList<>();

        list = postMapper.selectAll();

        return list;
    }
    public PostDTO getPostByIndex(long index)
    {
        PostDTO PostDTO = null;

        PostDTO = postMapper.selectByIndex(index);

        return PostDTO;
    }

    public boolean insertPost(PostDTO PostDTO)
    {
        if(postMapper.insertPost(PostDTO) != 0)
            return true;

        return false;
    }
    public boolean updatePost(long index,String password, String content)
    {
        if(postMapper.updatePost(index,password,content) != 0)
            return true;

        return false;
    }
    public boolean deletePost(long index)
    {
        if(postMapper.deletePost(index) != 0)
            return true;

        return false;
    }

    public boolean readPost(long index)
    {
        if(postMapper.readPost(index) != 0)
            return true;

        return false;
    }

}
