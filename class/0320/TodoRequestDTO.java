package todo.model.doamin ; 

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Builder
@Getter
@ToString
public class TodoRequestDTO {
    private String  title ; 
    private String  content ;
    private String  startDate ; 
    private String  endDate ; 
    private int     priority ; 
}
