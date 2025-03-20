package todo.ctrl ;

import java.util.Map;

import todo.model.doamin.TodoRequestDTO;
import todo.service.TodoService;

public class TodoUpdateController {
    
    private TodoService service ;
    public TodoUpdateController(TodoService service) {
        this.service = service ; 
    }
    public int updateTodo(Map<String, Object> map) {
        System.out.println(">>> TodoUpdateController updateTodo");
        return service.updateService(map) ;
    }
}
