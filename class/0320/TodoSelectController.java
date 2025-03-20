package todo.ctrl ;

import todo.model.doamin.TodoRequestDTO;
import todo.model.doamin.TodoResponseDTO;
import todo.service.TodoService;

import java.util.List;

public class TodoSelectController {
    
    private TodoService service ;
    
    public TodoSelectController() {
    }
    public TodoSelectController(TodoService service) {
        this.service = service ;
    }
    
    public List<TodoResponseDTO> selectTodo() {
        System.out.println(">>> TodoSelectController selectTodo");
        return service.selectService() ; 
    }
}
