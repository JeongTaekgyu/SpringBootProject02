package com.taek.w4springpjt.model;

import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

// 아래 어노테이션 3개중에 하나라도 빠지면 작동 안한다.
@Getter // private으로 변수가 있기때문에 Getter가 필요하다
@MappedSuperclass // Entity가 자동으로 컬럼으로 인식합니다.(Timestamped 클래스를 상속한 녀석이 자동으로 생성 시간과 수정 시간을 컬럼으로 잡도록 도와준다.)
@EntityListeners(AuditingEntityListener.class) // 생성/변경 시간을 자동으로 업데이트합니다.
public abstract class TimeStamped {
    /* abstract는 직접 구현 안되고 상속으로 만 써야한다.
   즉, new Timestamped(); 이렇게 못쓰고
   extends Timestamped 로만 써야한다.
 */
    @CreatedDate
    private LocalDateTime createdAt;

    @LastModifiedDate
    private LocalDateTime modifiedAt;
}
