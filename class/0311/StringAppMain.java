public class StringAppMain {

    public static void main(String[]args) {

        //문자열 리터럴을 이용해 생성(string constant pool에저장됨)
        String str01 = "suhy", str02 ="suhy";

        // str01과 str02는 같은 리터럴을 사용하므로 같은 주소를 참조함 (같은 객체)
        if(str01 == str02) {
            System.out.println("str01==str02");

        }
    // new String()은 힙 메모리에 새로운 String 객체를 생성함
        String str03= new String("suhy");
        String str04 = new String ("suhy");
// str03과 str04는 서로 다른 객체이므로 주소값이 다름
        if(str03 == str04){
            System.out.println("str03==str04");
        }
        // equals()는 문자열 값을 비교함. 값은 같으므로 true
        if(str03.equals(str04)){
            System.out.println("str03.equals(str04)");
        }

    
    }
    
}
