package com.taek.w4springpjt.controller;

import com.taek.w4springpjt.dto.CommentRequestDto;
import com.taek.w4springpjt.dto.PostRequestDto;
import com.taek.w4springpjt.model.Comment;
import com.taek.w4springpjt.repository.CommentRepository;
import com.taek.w4springpjt.security.UserDetailsImpl;
import com.taek.w4springpjt.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CommnetController {

    private final CommentRepository commentRepository;
    private final CommentService commentService;

    @Autowired
    public CommnetController(CommentRepository commentRepository, CommentService commentService){
        this.commentRepository = commentRepository;
        this.commentService = commentService;
    }

    @PostMapping("/create/comment")
    public void createComment( @RequestBody CommentRequestDto requestDto){
        Comment comment = new Comment(requestDto);
        commentRepository.save(comment);
    }

    @GetMapping("/views/commentList/{postid}")
    public List<Comment> readCommentList(@PathVariable Long postid) {
        System.out.println("~~ /views/commentList 의 postid : "+postid);
        //return commentRepository.findAllByOrderByModifiedAtDesc();
        return commentRepository.findAllByPostidOrderByModifiedAtDesc(postid);
    }

    // 반환해도 페이지 새로고침이 전부라서 반환은 안했다.
    @PutMapping("/update/comment/{id}")
    public void updateComment(@PathVariable Long id, @RequestBody CommentRequestDto requestDto){
        commentService.update(id, requestDto); //  comment.getId(); 를 반환함
    }

    // 반환도 안할건데 반환해서 뭐하게?
    @DeleteMapping("/delete/comment/{id}")
    public Long deleteComment(@PathVariable Long id, @AuthenticationPrincipal UserDetailsImpl userDetails){
        if(userDetails != null){
            commentRepository.deleteById(id);
        }
        // requestDto == null 이면 아무것도 안한다.
        return id;
    }
}
