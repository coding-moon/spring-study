package com.example.advanced.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Getter @ToString
@Table(name = "TBL_ORDER_PRODUCT")
public class OrderProduct {
    @Id @GeneratedValue
    @EqualsAndHashCode.Include
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    private Order order;

    @ManyToOne(fetch = FetchType.LAZY)
    private Product product;




}
