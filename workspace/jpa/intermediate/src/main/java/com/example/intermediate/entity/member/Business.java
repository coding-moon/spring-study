package com.example.intermediate.entity.member;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Table;
@Entity
@Table(name = "TBL_BUSINESS")
@Getter @Setter @ToString

public class Business extends User {
    //사업자 등록 반호
    private String registNum;
}
