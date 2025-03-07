// 메인 실행 클래스
public class OopMain {
    public static void main(String[] args) {
        // 객체 생성 (모든 값 입력)
        OopApp stu1 = new OopApp("박신형", "노량진", "2018");
        System.out.println(stu1.perInfo());
        System.out.println(stu1.stuInfo());

        // toString() 활용
        System.out.println(stu1); // 자동으로 toString() 호출됨

        // 기본 생성자 활용 (값 미정)
        OopApp stu2 = new OopApp();
        System.out.println(stu2);

        // Setter 활용 (동적으로 값 변경)
        stu2.setName("김철수");
        stu2.setAddress("서울");
        stu2.setYear("2023");

        // PersonV0 객체 생성
        PersonV0 per = PersonV0.builder()
                            .name("임정섭")
                            .addr("서울")
                            .build();
        System.out.println(per);

        // StudentV0 객체 생성
        StudentV0 stu = StudentV0.builder()
                            .name("최여명")
                            .addr("혜화")
                            .stuId("2018")
                            .build();
        System.out.println(stu.perInfo2());
        System.out.println(stu.stuInfo());

        // TeacherV0 객체 생성
        TeacherV0 tea = TeacherV0.builder()
                            .name("홍길동")
                            .addr("서울")
                            .subject("수학")
                            .build();
        System.out.println(tea.perInfo());
        System.out.println(tea.teaInfo());

        // ManagerV0 객체 생성
        ManagerV0 emp = ManagerV0.builder()
                            .name("이진규")
                            .addr("서초구")
                            .dept("교육운영팀")
                            .build();
        System.out.println(emp.perInfo());
        System.out.println(emp.empInfo());

        // Polymorphism 예시
        PersonV0 stu01 = new TeacherV0("박신형", "노량진", "2018");
        PersonV0 emp01 = new ManagerV0("이진규", "서초구", "교육운영팀");

        System.out.println(stu01.perInfo());
        System.out.println(emp01.perInfo());

        //다형성을 사용하는 이유
        PersonV0 [] perAry =new PersonV0[3];
        perAry[0]=stu;
        perAry[1]=tea;
        perAry[2]=emp;

        for(int idx=0; idx<perAry.length ; idx++){
            StudentV0 per =per perAry[idx];
        }
    }
}
