package com.taek.w4springpjt.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@AllArgsConstructor // 모든 필드 값을 파라미터로 받는 생성자를 만듦
@Setter
@Getter
public class SignupRequestDto {
//    @NotBlank(message = "닉네임은 필수 입력 값입니다.")
//    @Pattern(regexp= "^[a-zA-z0-9]{3,}$", message = "닉네임은 영문 대소문자 또는 숫자 3자리 이상이어야 합니다.")
    private String username;

//    @NotBlank(message = "비밀번호는 필수 입력 값입니다.")
//    @Pattern(regexp = "^[a-zA-z0-9]{4,}$", message = "비밀번호는 영문 대소문자 또는 숫자 4자리 이상이어야 합니다.")
    private String password;

//    @NotBlank(message = "이메일은 필수 입력 값입니다.")
//    @Email(message = "이메일 형식에 맞지 않습니다.")
    private String email;

    //private boolean admin = false;
    //private String adminToken = "";
}
