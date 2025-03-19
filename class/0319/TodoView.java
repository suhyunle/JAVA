package menu;

import front.FrontController;

import java.util.List;
import java.util.Scanner;

public class TodoView {

    private FrontController front = new FrontController();
    private Scanner scan = new Scanner(System.in);

    // 리스트 출력
    public void list() {
        List<TodoResponseDTO> list = front.list();
        System.out.println(">>> TODO LIST <<<");

        if (list.isEmpty()) {
            System.out.println("등록된 TODO가 없습니다.");
        } else {
            for (TodoResponseDTO todo : list) {
                System.out.println(todo);  // toString() 메서드가 DTO에 구현돼 있어야 함
            }
        }
    }

    // 등록 메서드
    public void register() {
        System.out.println(">>> TODO Register <<<");
        Scanner scan = new Scanner(System.in);
    
        System.out.print("제목: ");
        String title = scan.nextLine();
    
        System.out.print("내용: ");
        String content = scan.nextLine();
    
        System.out.print("시작일 (yyyy-MM-dd): ");
        String startDate = scan.nextLine();
    
        System.out.print("종료일 (yyyy-MM-dd): ");
        String endDate = scan.nextLine();
    
        System.out.print("우선순위 (숫자): ");
        int priority = scan.nextInt();
    
        int insertFlag = front.register(title, content, startDate, endDate, priority);
        System.out.println("Register Result: " + insertFlag);


        Scanner scan = new Scanner(System.in);
        try {
            String input = scan.nextLine();
            System.out.println("입력한 값: " + input);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            scan.close(); // 직접 닫아주기!
        }
        

    
    // 수정 메서드
    public void update() {
        System.out.println(">>> TODO Update <<<");

        System.out.print("수정할 TODO 번호 입력: ");
        int seq = Integer.parseInt(scan.nextLine());

        System.out.print("새 제목: ");
        String title = scan.nextLine();

        System.out.print("새 내용: ");
        String content = scan.nextLine();

        System.out.print("새 시작일 (yyyy-MM-dd): ");
        String startDate = scan.nextLine();

        System.out.print("새 종료일 (yyyy-MM-dd): ");
        String endDate = scan.nextLine();

        System.out.print("새 우선순위 (숫자): ");
        int priority = Integer.parseInt(scan.nextLine());

        public int update(int seq, String title, String content, String startDate, String endDate, int priority) {
            // 여기에 업데이트 로직 작성
            return 1; 
        }


        //새로 추가. 


    

    // 삭제 메서드
    public void delete() {
        System.out.println(">>> TODO DELETE <<<");

        System.out.print("삭제할 TODO 번호 입력: ");
        int seq = Integer.parseInt(scan.nextLine());

        int deleteFlag = front.delete(seq);
        System.out.println("Delete Result: " + deleteFlag);
    }

    // 종료일 처리 메서드
    public void processEndDate() {
        System.out.println(">>> TODO End Date 처리 <<<");
        int result = front.processEndDate();
        System.out.println("End Date Process Result: " + result);
    }
}
