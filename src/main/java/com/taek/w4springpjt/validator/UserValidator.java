package com.taek.w4springpjt.validator;

import com.taek.w4springpjt.dto.SignupRequestDto;

import java.util.regex.Pattern;

public class UserValidator {

    public static void validateUserInput(SignupRequestDto requestDto){
//        String idRegExp = "/^[a-zA-z0-9]{3,20}$/";
        //String userid = "ggg";
        // 이 안에서 repository에 있는 값을가져와서
        //
        //String pw2 = "1a2a3a!@#";

        if( !Pattern.matches("^[a-zA-z0-9]{3,}$", requestDto.getUsername()) ){
            throw new IllegalArgumentException("회원 닉네임이 유효하지 않습니다.");
        }

        if( requestDto.getPassword().length() < 4
                || requestDto.getUsername().contains(requestDto.getUsername()) ){
            throw new IllegalArgumentException("패스워드가 유효하지 않습니다.");
        }

        /*if( !pw2.equals( requestDto.getPassword() )){
            throw new IllegalArgumentException("패스워드가 유효하지 않습니다.");
        }*/

    }
}
