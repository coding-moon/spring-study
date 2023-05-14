package com.example.advanced.entity;


import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter @Setter @ToString
@Table(name = "TBL_ORDER")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Order {
    @Id @GeneratedValue
    @EqualsAndHashCode.Include
    private Long id;
    @Embedded
    @NotNull private Address address;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "order") // fk 걸어주기
    private List<OrderProduct> orderProducts; // Orderproduct 테이블에 fk 걸기


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MEMBER_ID") // fk 설정  멤버 아이디를 받겠다
    private Member member;


    // 1개 상품당 주문은 여러번 할 수 있다 1개 주문당
    // 중간 테이블 이 있는 이유 ?



}
