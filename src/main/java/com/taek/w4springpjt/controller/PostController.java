package com.taek.w4springpjt.controller;

import com.taek.w4springpjt.dto.PostRequestDto;
import com.taek.w4springpjt.model.Post;
import com.taek.w4springpjt.repository.PostRepository;
import com.taek.w4springpjt.security.UserDetailsImpl;
import com.taek.w4springpjt.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class PostController {

    private final PostService postService;
    private final PostRepository postRepository;

    @Autowired  // 필요한 의존 객체의 '타입'에 해당하는 빈(Bean)을 찾아 주입한다.
    public PostController(PostService postService, PostRepository postRepository){
        this.postService = postService;
        this.postRepository = postRepository;
    }

    @ResponseBody
    @GetMapping("/views/postInfo")
    public List<Post> readPostList(){
        return postRepository.findAllByOrderByModifiedAtDesc();
    }

    @GetMapping("/views/posting/{id}")
    public ModelAndView viewPost(@PathVariable Long id){
        ModelAndView mv = new ModelAndView();
        // Post형에 Optional 형을 넣는데 되는데.. 근데 예외처리 안하면 형이 달라서 안된다.
        // 아하 findBy(id)한게 Optional형 이기 때문에 이렇게 하는게 맞다
        // 아니면 post를 Optional 형으로 -> Optional <Post> post
        Post post = postRepository.findById(id).orElseThrow(
                () -> new NullPointerException("id가 존재하지 않습니다.")
        );

        mv.addObject("post",post);
        mv.addObject("timeAt",post.getModifiedAt());
        mv.setViewName("viewPost");
        return mv;
    }

    @GetMapping("/create/writePost")    // @AuthenticationPrincipal UserDetailsImpl userDetails 에 로그인 성공한 사용자의 정보가 넘어온다.
    public String viewCreatePost(Model model, @AuthenticationPrincipal UserDetailsImpl userDetails){
        try{
            model.addAttribute("username", userDetails.getUsername());
        } catch (NullPointerException exception){
            System.out.println("여긴 /create/writePost 인데 username 값이 없습니다.");
            //exception.printStackTrace();
        }
        return "createPost";
    }

    @ResponseBody   // 왜 그런거지... void라서 반환해주는 것도 없는데..
    @PostMapping("/create/writePost")
    public void createPost(@RequestBody PostRequestDto requestDto){
        Post post = new Post(requestDto);
        System.out.println(post.getUsername() +",  "+post.getTitle()+",  "+post.getContent());
        postRepository.save(post);
        //LocalDateTime cr = post.getCreatedAt();
        //LocalDateTime md = post.getModifiedAt();
    }
}
