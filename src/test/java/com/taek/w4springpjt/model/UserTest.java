/*package com.taek.w4springpjt.model;

import com.taek.w4springpjt.dto.SignupRequestDto;
import com.taek.w4springpjt.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {
//@Mock ProductRepository productRepository; - 서비스 목을 안만들어도 되는 코드
    @Nested
    @DisplayName("닉네임은 유효성 검사")
    class CreateUser{

        private String username;
        private String password;
        private String email;
        //private String confirmpw;

    // 그러면 이거 필요없고
        @BeforeEach
        void setup(){
            username = "taekgyu0602";
            password = "1a2a3a!@#";
            //confirmpw = "1a2a3a!@#";
            email = "wjdxorrb93@naver.com";
        }

        @Test
        @DisplayName("정상 케이스")
        void CreateUser_Normal(){
            // 이거 나중에 SignupRequestDto 에 @AllArgsConstructor 만들어서
            // 모든 변수의 생성자를 만들어서 springcore 프로젝트에 있는 방식으로 하자
            SignupRequestDto requestDto = new SignupRequestDto(
                username, password, email
            );

            User user = new User(requestDto);

            // 이렇게만 하면 될듯
            assertNull(user.getId());
                    // expected , actual
            assertEquals(username, user.getUsername());
            assertEquals(password, user.getPassword());
            //assertEquals(password, confirmpw);
        }

        @Nested
        @DisplayName("실패 케이스")
        class FailCase {
            @Nested
            @DisplayName("닉네임")
            class username {
                @Test
                @DisplayName("3자 미만")
                void fail1() {
                    username = "u1";

                    SignupRequestDto requestDto = new SignupRequestDto(
                        username, password, email
                    );

                    Exception exception= assertThrows(IllegalArgumentException.class, () -> {
                        new User(requestDto);
                    });

                    assertEquals("회원 닉네임이 유효하지 않습니다.", exception.getMessage());
                }

                @Test
                @DisplayName("특수문자")
                void fail2() {
                    username = "test!@#";

                    SignupRequestDto requestDto = new SignupRequestDto(
                            username, password, email
                    );

                    Exception exception= assertThrows(IllegalArgumentException.class, () -> {
                        new User(requestDto);
                    });

                    assertEquals("회원 닉네임이 유효하지 않습니다.", exception.getMessage());
                }
            }

            @Nested
            @DisplayName("비민번호")
            class password{
                @Test
                @DisplayName("1자 이상 4자 미만")
                void fail1() {

                    password = "p1";

                    SignupRequestDto requestDto = new SignupRequestDto(
                            username, password, email
                    );

                    Exception exception= assertThrows(IllegalArgumentException.class, () -> {
                        new User(requestDto);
                    });

                    assertEquals("패스워드가 유효하지 않습니다.", exception.getMessage());
                }

                @Test
                @DisplayName("null")
                void fail2() {
                    password = "";

                    SignupRequestDto requestDto = new SignupRequestDto(
                            username, password, email
                    );

                    Exception exception= assertThrows(IllegalArgumentException.class, () -> {
                        new User(requestDto);
                    });

                    assertEquals("패스워드가 유효하지 않습니다.", exception.getMessage());
                }
            }


        }

    }
}*/