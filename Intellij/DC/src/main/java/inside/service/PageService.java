package inside.service;

import inside.domain.PageDTO;
import inside.domain.PostDTO;
import inside.mapper.PostMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PageService {

    @Autowired(required = false)
    private PostMapper postMapper;

    public PageDTO selectPostPage(int page, int limit)
    {
        List<PostDTO> list = new ArrayList<>();
        list = postMapper.selectPage(page, limit);
        PageDTO pageDTO = new PageDTO(limit,page,postMapper.totalPost(),list);

        return pageDTO;
    }

}
