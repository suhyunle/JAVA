package todo.ctrl;

import java.util.Comparator;
import java.util.List;

import todo.model.doamin.TodoResponseDTO;
import todo.service.TodoService;

public class TodoSortController {
    private TodoService service ;
    
    public TodoSortController() {
    }
    public TodoSortController(TodoService service) {
        this.service = service ;
    }
    
    public List<TodoResponseDTO> sortTodo() {
        System.out.println(">>> TodoSortController sortTodo");
        List<TodoResponseDTO> list = service.selectService() ; 
        return list
                .stream()
                .sorted(Comparator.comparing(TodoResponseDTO::getPriority).reversed()).toList() ;
            
    }
}
