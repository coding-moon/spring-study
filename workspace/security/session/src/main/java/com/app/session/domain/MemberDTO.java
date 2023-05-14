package com.app.session.domain;


import com.app.session.type.Role;
import com.sun.istack.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.time.LocalDate;

@Component
@Data
@NoArgsConstructor
public class MemberDTO {
    private Long id;
    private String memberName;
    @DateTimeFormat (pattern = "yyyy.MM.dd")
    private LocalDate memberBirth;
    private String memberPhoneNumber;
    private String memberId;
    private String memberPassword;
    private String memberEmail;
    private Role memberRole;
}
