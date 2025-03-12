import java.util.HashSet;
import java.util.Set;

public class SetMain {

    public static void main(String[] args) {

        Set<String> set = new HashSet<>();
        set.add("jslim");
        set.add("siat");
        System.out.println( set ) ;
        Object [] ary = set.toArray() ;   
        for(Object str : ary) {
            System.out.println( str );
        }
                
    }
}
