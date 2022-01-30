package com.taek.w4springpjt.service;

import com.taek.w4springpjt.dto.PostRequestDto;
import com.taek.w4springpjt.model.Post;
import com.taek.w4springpjt.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

// @RequiredArgsConstructor는 초기화 되지않은 `final` 필드나, `@NonNull` 이 붙은 필드에 대해 생성자를 생성해 준다. 주로 의존성 주입(Dependency Injection) 편의성을 위해서 사용되곤 합니다.
// 그래서 new PostRepository 로 생성하지 않아도 된다
@RequiredArgsConstructor
@Service
public class PostService {

    private final PostRepository postRepository;

    @Transactional
    public Long update(Long id, PostRequestDto requestDto){
        Post post = postRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("아이디가 존재하지 않습니다.")
        );
        post.update(requestDto);
        return post.getId();
    }
}
