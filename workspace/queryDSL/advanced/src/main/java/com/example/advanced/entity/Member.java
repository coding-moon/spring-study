package com.example.advanced.entity;

import com.sun.istack.NotNull;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Getter @ToString
@Table(name = "TBL_MEMBER")
public class Member {
    @Id @GeneratedValue
    @EqualsAndHashCode.Include
    private Long id;
    @Column(unique = true)
    @NotNull private String memberId;
    @NotNull private String memberPassword;
    @NotNull private String memberName;
    @Embedded
    @NotNull private Address address;


}
