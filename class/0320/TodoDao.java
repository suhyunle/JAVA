package todo.model.dao ; 

import java.lang.StackWalker.Option;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import todo.model.doamin.TodoRequestDTO;
import todo.model.doamin.TodoResponseDTO;

public class TodoDao {
    private List<TodoResponseDTO> list ; 
    private int idx ;
    public TodoDao() {
        list = new ArrayList<TodoResponseDTO>() ;
    }
    // 입력
    public int insertRow(TodoRequestDTO request) {
        System.out.println(">>> dao insertRow");
        TodoResponseDTO response = TodoResponseDTO.builder()
                                    .seq(idx++)
                                    .title(request.getTitle())
                                    .content(request.getContent())
                                    .check(0)
                                    .startDate(request.getStartDate())
                                    .endDate(request.getEndDate())
                                    .priority(request.getPriority())
                                    .build();
            
        list.add(response);
        return 1 ; 
    }
    // 상세보기
    public Optional<TodoResponseDTO> selectRow(int seq) {
        System.out.println(">>> dao selectRow");
        Optional<TodoResponseDTO> response = Optional.empty() ; 
        for(int idx = 0 ; idx < list.size() ; idx++) {
            if( list.get(idx).getSeq() == seq) {
                response =  Optional.of( list.get(idx) ) ;
            }
        }
        return response  ;  
    }
    // 삭제
    public int deleteRow(int seq) {
        System.out.println(">>> dao deleteRow");
        int flag = 0 ; 
        for(int idx = 0 ; idx < list.size() ; idx++) {
            if( list.get(idx).getSeq() == seq) {
                list.remove(idx) ;
            }
        }
        return flag  ;  
    }
    // 수정 
    public int updateRow(Map<String, Object> map) {
        System.out.println(">>> dao updateRow");
        int flag = 0 ; 
        for(int idx = 0 ; idx < list.size() ; idx++) {
            if( list.get(idx).getSeq() == (Integer)(map.get("seq")) ) {
                list.get(idx).setContent((String)(map.get("content"))) ;
                list.get(idx).setCheck((Integer)(map.get("check"))) ;
                flag = 1 ; 
            }
        }
        return flag  ;
    }
    // 전체보기
    public List<TodoResponseDTO> selectRow() {
        System.out.println(">>> dao selectRow");
        return list ; 
    }
    
}
