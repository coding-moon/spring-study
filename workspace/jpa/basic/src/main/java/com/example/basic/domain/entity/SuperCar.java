package com.example.basic.domain.entity;

import com.example.basic.domain.entity.type.SuperCarBrand;
import com.sun.istack.NotNull;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.sql.Date;
import java.time.LocalDateTime;

@Entity
@Getter @Setter @ToString
@Table (name = "TBL_SUPER_CAR")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class SuperCar {
    @Id
    @GeneratedValue // 시퀀스 생성
    private Long SuperCarId;
    @NotNull //JAVA에서의 Validation(DB와 상관 없음)
    private String SuperCarName;
    //DBMS 에서의 NOT null 제약 조견 추가(JAVA와 상관없음)
    private String SuperCarColor;
    private int SuperCarPrice;
    @DateTimeFormat(pattern = "yyyy/mm/dd HH-mm-ss")
    private LocalDateTime SuperCarReleaseDate;
    @Enumerated(EnumType.STRING) @NotNull// 타입 바꾸기
    private SuperCarBrand superCarBrand;

    @Builder
    public SuperCar(Long superCarId, String superCarName, String superCarColor, int superCarPrice, LocalDateTime superCarReleaseDate, SuperCarBrand superCarBrand) {
       this.SuperCarId = superCarId;
       this.SuperCarName = superCarName;
       this.SuperCarColor = superCarColor;
       this.SuperCarPrice = superCarPrice;
       this.SuperCarReleaseDate = superCarReleaseDate;
       this.superCarBrand = superCarBrand;
    }
}
