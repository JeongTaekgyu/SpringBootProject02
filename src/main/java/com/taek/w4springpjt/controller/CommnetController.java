package com.taek.w4springpjt.controller;

import com.taek.w4springpjt.dto.CommentRequestDto;
import com.taek.w4springpjt.dto.PostRequestDto;
import com.taek.w4springpjt.model.Comment;
import com.taek.w4springpjt.repository.CommentRepository;
import com.taek.w4springpjt.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
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

        System.out.println("~~~ 방지칸"+requestDto.getUsername() +", "+requestDto.getComment()+", "+requestDto.getPostid());
        Comment comment = new Comment(requestDto);
        commentRepository.save(comment);
    }

    @GetMapping("/views/commentList")
    public List<Comment> readCommentList() {
        System.out.println("~~ /views/commentList");
        return commentRepository.findAllByOrderByModifiedAtDesc();
    }

    // 반환해도 페이지 새로고침이 전부라서 반환은 안했다.
    @PutMapping("/update/comment/{id}")
    public void updateComment(@PathVariable Long id, @RequestBody CommentRequestDto requestDto){
        commentService.update(id, requestDto); //  comment.getId(); 를 반환함
    }

    // 반환도 안할건데 반환해서 뭐하게?
    @DeleteMapping("/delete/comment/{id}")
    public Long deleteComment(@PathVariable Long id){
        commentRepository.deleteById(id);
        return id;
    }

    /*@PutMapping("/api/update/{id}")
    public Long updateMemo(@PathVariable Long id, @RequestBody PostRequestDto requestDto){
        // 파라미터 안에는 받아올 데이터가 있다.
        return postService.update(id, requestDto);
    }*/

    /*@PostMapping("/api/comments/{bid}")
    public Long createComment(@PathVariable Long bid, @RequestBody CommentRequestDto requestDto){
        Comment comment = commentRepository.save(requestDto.toEn)
    }*/
}
