package com.taek.w4springpjt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing  // JPA를 사용할 건데 데이터 변동이 있으면 JPA가 알아서 반영한다. - Timestamped 사용하기 때문에 넣어준다.
@SpringBootApplication
public class W4springPjtApplication {

    public static void main(String[] args) {
        SpringApplication.run(W4springPjtApplication.class, args);
    }

}
