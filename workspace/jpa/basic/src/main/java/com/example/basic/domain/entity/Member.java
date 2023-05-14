package com.example.basic.domain.entity;

import com.example.basic.domain.entity.type.MemberType;
import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.*;

@Entity // Entity에서는 @Data를 사용하기 보다는 직접 골라서 작성하는 것이 좋다.
@Getter @Setter @ToString
@Table(name = "TBL_MEMBER")
@NoArgsConstructor(access = AccessLevel.PROTECTED) // 외부에서 객체 생성을 막음과 동시에, Spring에서는 사용할 수 있도록 PROTECTED 설정한다.

public class Member {
    @Id @GeneratedValue // 시퀀스 생성
    private Long memberId;
    @NotNull //JAVA에서의 Validation(DB와 상관 없음)
    private String memberName;
    @Column(unique = true, nullable = false) //DBMS 에서의 NOT null 제약 조견 추가(JAVA와 상관없음)
    private String memberEmail;
    private String memberPassword;
    private int memberAge;
    @Enumerated(EnumType.STRING) @NotNull// 타입 바꾸기
    private MemberType memberType;

    @Builder // 초기화 생성자의 모든 매개변수에 값이 들어와야 메모리에 할당된다.
    public Member(String memberName, String memberEmail, String memberPassword, int memberAge, MemberType memberType) {
        this.memberName = memberName;
        this.memberEmail = memberEmail;
        this.memberPassword = memberPassword;
        this.memberAge = memberAge;
        this.memberType = memberType;
    }


}
//jpa 데이터 어노 테이션 금지 디테일한 수정 불가능 참조순환 발생