package com.example.advanced.entity;

import com.sun.istack.NotNull;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter @Setter @ToString
@Table(name = "TBL_PRODUCT")
public class Product {
    @Id @GeneratedValue
    @EqualsAndHashCode.Include
    private Long id;
    @NotNull private String productName;

    @ColumnDefault(value = "0")
    private Long productPrice;

    @ColumnDefault(value = "0")
    private Long productStock;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "product")
    private List<OrderProduct> orderProducts;
}
