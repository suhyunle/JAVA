package todo.ctrl ;

import java.util.Optional;

import todo.model.doamin.TodoResponseDTO;
import todo.service.TodoService;

public class TodoReadController {

    private TodoService service ;
    
    public TodoReadController(TodoService service) {
        this.service = service ;
    }
    
    public TodoResponseDTO selectTodo(int seq) {
        System.out.println(">>> TodoReadController selectTodo");
        Optional<TodoResponseDTO> response = service.selectService(seq) ; 
        if( response.isPresent() ) {
            return response.get() ; 
        } else {
            return null ;
        }
    }
}
