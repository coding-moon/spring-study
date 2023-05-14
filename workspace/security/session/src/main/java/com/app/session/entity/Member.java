package com.app.session.entity;


import com.app.session.type.Role;
import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Getter @ToString
@NoArgsConstructor(access = AccessLevel.PROTECTED) //매개변수 없는 생성자
// access = AccessLevel.PROTECTED  다른 패키지에 소속된 클래스 접근 불가
//access = AccessLevel.PRIVATE 다른 외부 클래스 접근 불가
@Table(name = "TBL_MEMBER")
public class Member {
    @Id @GeneratedValue
    private Long id;
    @NotNull private String memberName;
    @NotNull private LocalDate memberBirth;

    @Column(unique = true)
    @NotNull private String memberId;

    @Column(unique = true)
    @NotNull private String memberPhoneNumber;
    @NotNull private String memberPassword;

    @Column(unique = true)
    @NotNull private String memberEmail;
    @Enumerated(EnumType.STRING)
    @NotNull private Role memberRole;

    @Builder
    public Member(Long id, String memberName, LocalDate memberBirth, String memberPhoneNumber, String memberId, String memberPassword, String memberEmail, Role memberRole) {
        this.id = id;
        this.memberName = memberName;
        this.memberBirth = memberBirth;
        this.memberPhoneNumber = memberPhoneNumber;
        this.memberId = memberId;
        this.memberPassword = memberPassword;
        this.memberEmail = memberEmail;
        this.memberRole = memberRole;
    }
}
