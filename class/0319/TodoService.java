package menu;

import java.util.ArrayList;
import java.util.List;

public class TodoService {

    private static List<TodoRequestDTO> todoList = new ArrayList<>(); // 임시 저장 리스트

    // Todo 등록 서비스
    public int insertService(TodoRequestDTO request) {
        System.out.println(">>> TodoService insertService()");

        // 임시 리스트에 Todo 추가
        todoList.add(request);
        return 1; // 성공적으로 추가
    }

    // 예시로 등록된 todo 목록 반환하는 메서드 (옵션)
    public List<TodoRequestDTO> getTodoList() {
        return todoList;
    }
}
