package todo.front;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import todo.ctrl.TodoCheckController;
import todo.ctrl.TodoDeleteController;
import todo.ctrl.TodoInsertController;
import todo.ctrl.TodoReadController;
import todo.ctrl.TodoSelectController;
import todo.ctrl.TodoSortController;
import todo.ctrl.TodoUpdateController;
import todo.factory.BeanFactory;
import todo.model.doamin.TodoRequestDTO;
import todo.model.doamin.TodoResponseDTO;

public class FrontController {
    
    private BeanFactory factory ; 
    public FrontController() {
        factory = BeanFactory.getInstance() ; 
    }

    
    // 1 : 전체보기 , 2 : 입력 , 3 : 수정 , 4 : 삭제 
    public List<TodoResponseDTO> sort() {
        System.out.println(">>> FrontController sort");
        TodoSortController sortCtrl = (TodoSortController)factory.getCtrl("sort");
        List<TodoResponseDTO> list = sortCtrl.sortTodo() ;
        return list ;
    }

    public List<TodoResponseDTO> list() {
        System.out.println(">>> FrontController list");
        TodoSelectController selectCtrl = (TodoSelectController)factory.getCtrl("list");
        List<TodoResponseDTO> list = selectCtrl.selectTodo() ;
        return list ;
    }
    public List<TodoResponseDTO> checkList() {
        System.out.println(">>> FrontController check list");
        TodoCheckController checkCtrl = (TodoCheckController)factory.getCtrl("check");
        List<TodoResponseDTO> list = checkCtrl.checkTodo() ;
        return list ;
    }
    public int register(String title, String content, String startDate, String endDate, int priority) {
        System.out.println(">>> FrontController register");
        TodoInsertController insertCtrl = (TodoInsertController)factory.getCtrl("register");
        TodoRequestDTO request = TodoRequestDTO.builder()
                                    .title(title)
                                    .content(content)
                                    .startDate(startDate)
                                    .endDate(endDate)
                                    .priority(priority)
                                    .build();
        int insertFlag = insertCtrl.insertTodo(request);
        return insertFlag ; 
    }
    public int update(int seq , String content, int check) {
        System.out.println(">>> FrontController update");
        TodoUpdateController updateCtrl = (TodoUpdateController)factory.getCtrl("update") ;
        Map<String, Object> map = new HashMap<>();
        map.put("seq", seq);
        map.put("content", content) ; 
        map.put("check", check) ; 
        int updateFlag = updateCtrl.updateTodo(map); 
        return updateFlag ; 
    }
    public int delete(int seq) {
        System.out.println(">>> FrontController delete");
        TodoDeleteController deleteCtrl = (TodoDeleteController)factory.getCtrl("delete") ;
        int deleteFlag = deleteCtrl.deleteTodo(seq);
        return deleteFlag ; 
    }

    public TodoResponseDTO read(int seq) {
        System.out.println(">>> FrontController read");
        TodoReadController readCtrl  = (TodoReadController)factory.getCtrl("read");
        return readCtrl.selectTodo(seq);
    }
}
