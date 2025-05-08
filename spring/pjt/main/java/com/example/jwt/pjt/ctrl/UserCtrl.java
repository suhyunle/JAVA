package com.example.jwt.pjt.ctrl;

import com.example.jwt.pjt.dto.UserRequestDTO;
import com.example.jwt.pjt.dto.PostRequestDTO;
import com.example.jwt.pjt.domain.service.UserService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/user")
public class UserCtrl {

    @Autowired
    private UserService service;

    @PostMapping("/usercreate")
    public String createUser(@RequestBody UserRequestDTO params) {
        System.out.println("debug >>>> UserCtrl createUser");
        return null;
    }

    @PostMapping("/{email}/post")
    public String createPost(@PathVariable("email") String email, @RequestBody PostRequestDTO postRequest) {
        System.out.println("debug >>>> UserCtrl createPost");
        return null;
    }

    @GetMapping("/{email}/list")
    public ResponseEntity<List<PostRequestDTO>> getUserPosts(@PathVariable("email") String email) {
        System.out.println("debug >>>> UserCtrl getUserPosts");
        List<PostRequestDTO> lst = service.getUserPostService(email);
        return ResponseEntity.ok().body(lst);
    }


    @PutMapping("/{id}/update")
    public String updatePost(@PathVariable("id") String email,
                            @RequestBody PostRequestDTO params) {
        System.out.println("debug>>>> userctrl updatePost");
        service.updatePostService(email,params);
  
        return "Post updated successfully";
    }

    @DeleteMapping("/{email}/{postId}")
    public String deletePost(@PathVariable("email") String email,
                         @PathVariable("postId") String postId) {
        System.out.println("debug>>user ctrl deletePost");
        service.deletePostService(email, postId);
        return "Post deleted successfully";
}
}
