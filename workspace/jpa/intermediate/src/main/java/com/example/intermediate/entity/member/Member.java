package com.example.intermediate.entity.member;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table
@Getter @Setter @ToString
public class Member extends User {
    //주민번호
    @NotNull private String socialSecurity;
}
