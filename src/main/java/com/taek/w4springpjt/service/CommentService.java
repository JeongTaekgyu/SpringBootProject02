package com.taek.w4springpjt.service;

import com.taek.w4springpjt.dto.CommentRequestDto;
import com.taek.w4springpjt.model.Comment;
import com.taek.w4springpjt.repository.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
public class CommentService {

    private final CommentRepository commentRepository;

    @Transactional
    public Long update(Long id, CommentRequestDto requestDto){
        Comment comment = commentRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("comment의 아이디가 존재하지 않습니다.")
        );
        System.out.println("~~~한번 찍어");
        comment.update(requestDto);
        return comment.getId();
    }
}
