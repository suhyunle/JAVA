package todo.ctrl;

import java.util.List;

import todo.model.doamin.TodoResponseDTO;
import todo.service.TodoService;

public class TodoCheckController {
    
    private TodoService service ;
    public TodoCheckController() {
    }
    public TodoCheckController(TodoService service) {
        this.service = service ;
    }
    
    public List<TodoResponseDTO> checkTodo() {
        System.out.println(">>> TodoCheckController checkTodo");
        List<TodoResponseDTO> list = service.selectService() ; 
        return list.stream().filter(s -> s.getCheck() == 1).toList();
    }
}
