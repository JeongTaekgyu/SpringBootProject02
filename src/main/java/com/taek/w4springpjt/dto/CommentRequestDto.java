package com.taek.w4springpjt.dto;

import lombok.Data;
import lombok.Getter;

//@Data
@Getter
public class CommentRequestDto {
    private String username;
    private String comment;
    private Long postid;
}
