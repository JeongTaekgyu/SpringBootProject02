package com.taek.w4springpjt.model;

import com.taek.w4springpjt.dto.CommentRequestDto;
import com.taek.w4springpjt.dto.PostRequestDto;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor // 기본생성자를 만듭니다.
@Getter
@Entity // 테이블과 연계됨을 스프링에게 알려줍니다.
public class Comment extends TimeStamped{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String username;  // 이거 사실 다른 테이블과 연관관계 있어야 한다. username으로 ?

    @Column(nullable = false)
    private String comment;

    @Column(nullable = false)
    private Long postid;

    /*@ManyToOne
    @JoinColumn(name = "post_id")   // 매핑할 외래키 이름
    private Post post;

    public Comment(CommentRequestDto requestDto, Post post, User user){
        this.post = post;
        //this.user = user;
        this.comment = requestDto.getComment();
    }*/

    public Comment(CommentRequestDto requestDto){
        this.username = requestDto.getUsername();
        this.comment = requestDto.getComment();
        this.postid = requestDto.getPostid();
    }

    public void update(CommentRequestDto requestDto){
        this.username = requestDto.getUsername();
        this.comment = requestDto.getComment();
        this.postid = requestDto.getPostid();
    }
}
