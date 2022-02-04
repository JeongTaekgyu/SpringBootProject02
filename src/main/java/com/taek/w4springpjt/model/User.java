package com.taek.w4springpjt.model;

import com.taek.w4springpjt.dto.SignupRequestDto;
import com.taek.w4springpjt.validator.UserValidator;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter // get 함수를 일괄적으로 만들어줍니다.
@NoArgsConstructor // 기본 생성자를 만들어줍니다.
@Entity // DB 테이블 역할을 합니다.
public class User {

    // ID가 자동으로 생성 및 증가합니다.
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;

    // nullable: null 허용 여부
    // unique: 중복 허용 여부 (false 일때 중복 허용)
    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(nullable = true, unique = true)
    private String email;

//    @Column(nullable = false)
//    @Enumerated(value = EnumType.STRING)    // db에 저장될 때는 string으로 저장된다.
//    private UserRoleEnum role;

    @Column(unique = true)
    private Long kakaoId;

    // 일반 유저 생성자
//    public User(String username, String password, String email) {
//        this.username = username;
//        this.password = password;
//        this.email = email;
//        this.kakaoId = null;
//    }

    public User(SignupRequestDto requestDto){
        UserValidator.validateUserInput(requestDto);

        this.username = requestDto.getUsername();
        this.password = requestDto.getPassword();
        this.email = requestDto.getEmail();
    }

    // 일반 유저 생성자
    public User(String username, String password, String email) {
        //UserValidator.validateUserInput(username, password, email);
        this.username = username;
        this.password = password;
        this.email = email; // null 이다.
        this.kakaoId = null;
    }

    // 카카오 id 생성자
    public User(String username, String password, String email, Long kakaoId) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.kakaoId = kakaoId;
    }
}
