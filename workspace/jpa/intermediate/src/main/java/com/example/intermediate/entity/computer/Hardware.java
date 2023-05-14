package com.example.intermediate.entity.computer;

import lombok.*;

import javax.persistence.Embeddable;

// Embeddable
// 상속관계가 아닌 필드의 그룹화(모듈화)를 목적으로 사용된다.
// 그룹화된 필드는 따로 사용하지 않고 한 번에 사용하는 목적으로 설계한다.

@Embeddable
@Getter @ToString
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Hardware {
    private Integer ram;
    private Integer ssd; //기본 단위 GB
    private String gpu;
    private String processor;
    @Builder

    public Hardware(Integer ram, Integer ssd, String gpu, String processor) {
        this.ram = ram;
        this.ssd = ssd;
        this.gpu = gpu;
        this.processor = processor;
    }
}
