package com.taek.w4springpjt.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.taek.w4springpjt.dto.SignupRequestDto;
import com.taek.w4springpjt.repository.UserRepository;
import com.taek.w4springpjt.service.KakaoUserService;
import com.taek.w4springpjt.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserController {

    private final UserService userService;
    private final KakaoUserService kakaoUserService;
    private final UserRepository userRepository;

    @Autowired              // DI 를 받는다
    public UserController(UserService userService, KakaoUserService kakaoUserService, UserRepository userRepository) {
        this.userService = userService;
        this.kakaoUserService = kakaoUserService;
        this.userRepository = userRepository;
    }

    @GetMapping("/user/login")
    public String login(){
        System.out.println("get login 여기는 아니야");
        return "login";
    }

    @GetMapping("/user/signup")
    public String signup(){
        return "signup";
    }

    @PostMapping("/user/signup")
    public String registerUser(SignupRequestDto requestDto) {
        System.out.println("~~~post /user/signup username : "+requestDto.getUsername());

        // 아래 주석처럼 새로고침은 하지 말자
        // 중복이 아닐 경우
//        if( userService.checkIdDuplicate(requestDto.getUsername()) ){
//            userService.registerUser(requestDto);
//        } else{ // 중복일 경우 그런데 null 인 경우는 없을까 - 나중엔 고려하자
//            return "signup";
//        }
        userService.registerUser(requestDto);
        return "redirect:/user/login";
    }

    @ResponseBody
    @GetMapping("/user/idDupCheck/{userid}")
    public Boolean idDupCheck(@PathVariable String userid ){
        System.out.println("~~~들어와라 : "+userid);
        //String idchk = "success";

        return userService.checkIdDuplicate(userid);
        //return idchk;
    }

    /*@ResponseBody
    @PostMapping("/api/idDupCheck")
    public String idDupCheck(String userid, @RequestBody SignupRequestDto requestDto){
        System.out.println("~~~ 오질 않네");
        System.out.println("~~~userid : "+userid);
        System.out.println("requestDto.getUsername() :"+requestDto.getUsername());
        //boolean chk = false;
        //System.out.println("컨트롤러 /api/idDupCheck/"+userid);
        String idChk = userService.checkIdDuplicate(userid); // fail이면 중복
        System.out.println("idChk : "+idChk);
        return idChk;
    }*/

    @GetMapping("/user/kakao/callback")
    public String kakaoLogin(@RequestParam String code) throws JsonProcessingException {
        // authorizedCode: 카카오 서버로부터 받은 인가 코드
        System.out.println("~~~get /user/kakao/callback 여기도 아니야");
        kakaoUserService.kakaoLogin(code);

        return "redirect:/";
    }
}
