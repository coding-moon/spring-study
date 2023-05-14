package com.example.intermediate.entity.computer;


import com.example.intermediate.audit.Period;
import com.sun.istack.NotNull;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter @Setter @ToString
@Table(name = "TBL_COMPUTER")
public class Computer extends Period {
    @Id @GeneratedValue
    @NotNull private Long id;
    @NotNull private Integer screen;
    @NotNull private String brand;
    @NotNull private String name;
    @NotNull private String price;
    @NotNull private LocalDateTime releaseDate;
    @Embedded
    @NotNull private  Hardware hardware;
//    private Integer ram;
//    private Integer ssd;
//    private String gpu;
//    private String processor;
//    private LocalDateTime registerDate;
//    private LocalDateTime updateDate;
@Builder

    public Computer(Long id, Integer screen, String brand, String name, String price, LocalDateTime releaseDate, Hardware hardware) {
        this.id = id;
        this.screen = screen;
        this.brand = brand;
        this.name = name;
        this.price = price;
        this.releaseDate = releaseDate;
        this.hardware = hardware;
    }
}
