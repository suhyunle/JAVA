package menu;

import java.util.Scanner;

import Front.FrontController;

public class TodoView {

    public void control() {
        Scanner scanner = new Scanner(System.in);
        boolean isRunning = true;

        //  FrontController 객체 생성
        FrontController fc = new FrontController();

        while (isRunning) {
            // 메뉴 출력
            System.out.println(">>>> Todo Service Menu <<<<");
            System.out.println("1. 목록보기 / 2. 작성 / 3. 수정 / 4. 삭제 / 5. 종료");
            System.out.print("원하시는 번호를 선택하세요: ");


            // 사용자 입력
            int choice = scanner.nextInt();

            // FrontController 메소드 호출
            switch (choice) {
                case 1:
                    fc.list();
                    break;
                case 2:
                    fc.register();
                    break;
                case 3:
                    fc.update();
                    break;
                case 4:
                    fc.delete();
                    break;
                case 5:
                    System.out.println("프로그램을 종료합니다.");
                    isRunning = false;
                    break;
                default:
                    System.out.println("잘못된 선택입니다. 다시 입력해주세요.");
            }

            System.out.println(); // 줄 바꿈
        }

        scanner.close();
    }

    // 메인 메소드에서 프로그램 실행
    public static void main(String[] args) {
        TodoView view = new TodoView();
        view.control();  // TodoView의 control 호출
    }
}
