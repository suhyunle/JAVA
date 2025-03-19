

package menu;

public class TodoInsertController {

    private TodoService service;

    public TodoInsertController() {
        service = new TodoService(); // TodoService 인스턴스를 생성
    }

    // Todo 등록
    public int insertTodo(TodoRequestDTO request) {
        System.out.println(">>> ctrl insertCtrl");
        return service.insertService(request); // 서비스에 요청을 전달하여 데이터를 저장
    }
}

