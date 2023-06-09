package com.example.intermediate.audit;


import lombok.Getter;

import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import java.time.LocalDateTime;

// @MappedSuperclass
// 자바 진영에서는 상속관계이지만, RDB진영에는 상속관계가 아님을 표시할 때 사용,
// 각 필드를 개별적으로 사용하거나 바로 접근해야 할 때 사용.


@MappedSuperclass
@Getter
public abstract class Period {
    private LocalDateTime createDate;
    private LocalDateTime updateDate;

    @PrePersist
    public void  create() {
        this.createDate = LocalDateTime.now();
        this.updateDate = LocalDateTime.now();
    }

    @PreUpdate
    public void update() {
        this.updateDate = LocalDateTime.now();
    }
}
