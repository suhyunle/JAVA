package todo.model.doamin ; 

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Builder
@Getter
@Setter
@ToString
public class TodoResponseDTO {

    private int     seq ; 
    private String  title ; 
    private String  content ;
    private String  startDate ; 
    private int     check ; 
    private String  endDate ; 
    private int     priority ; 

}
