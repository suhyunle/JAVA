public class StringAppMain {

    public static void main(String[]args) {

        String str01 = "siat", str02 ="siat";
        if(str01 == str02) {
            System.out.println("str01==str02");

        }

        String str03= new String("siat");
        String str04 = new String ("siat");

        if(str03 == str04){
            System.out.println("str03==str04");
        }
        if(str03.equals(str04)){
            System.out.println("str03.equals(str04)");
        }

    
    }
    
}
