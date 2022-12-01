package inside.service;

import inside.domain.CommentDTO;
import inside.mapper.CommentMapper;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Log4j2
public class CommentService {

    @Autowired(required = false)
    CommentMapper commentMapper;

    public CommentDTO getCommentByIndex(long index)
    {
        CommentDTO CommentDTO = null;

        CommentDTO = commentMapper.selectCommentByIndex(index);

        return CommentDTO;
    }

    public List<CommentDTO> getCommentAll(long postIndex)
    {
        List<CommentDTO> list = new ArrayList<>();

        list = commentMapper.selectPostAllComment(postIndex);

        return list;
    }

    public boolean insertComment(CommentDTO commentDTO)
    {
        if(commentMapper.insertComment(commentDTO) != 0)
            return true;

        return false;
    }
    public boolean updateComment(long index,String password, String content)
    {
        if(commentMapper.updateComment(index,password,content) != 0)
            return true;

        return false;
    }
    public boolean deleteComment(long index)
    {
        if(commentMapper.deleteComment(index) != 0)
            return true;

        return false;
    }
}
