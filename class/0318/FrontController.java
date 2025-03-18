package Front;

import menu.TodoDeleteController;
import menu.TodoInsertController;
import menu.TodoSelectController;
import menu.TodoUpdateController;

public class FrontController {

    

    //전체보기
    public void list() {
        System.out.println(">>> FrontController list");
        TodoSelectController selectCtrl = new TodoSelectController();
        // selectCtrl.select(); // 실제 동작 메소드 호출
    }

    //등록하기
    public void register() {
        System.out.println(">>> FrontController register");
        TodoInsertController insertCtrl = new TodoInsertController();
        // insertCtrl.insert();
    }

    //수정하기
    public void update() {
        System.out.println(">>> FrontController update");
        TodoUpdateController updateCtrl = new TodoUpdateController();
        // updateCtrl.update();
    }

    //삭제하기
    public void delete() {
        System.out.println(">>> FrontController delete");
        TodoDeleteController deleteCtrl = new TodoDeleteController();
        // deleteCtrl.delete();
    }
}

