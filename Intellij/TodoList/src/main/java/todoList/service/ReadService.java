package todoList.service;

import org.springframework.stereotype.Service;
import todoList.dao.TodoDAO;
import todoList.domain.TodoFile;

import java.util.List;

@Service
public class ReadService {

    private final TodoDAO tododao;

    public ReadService(TodoDAO tododao) {
        this.tododao = tododao;
    }

}
