package com.example.ex02.domain.DTO;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class ProductDTO {
    private Long productId;
    private Long orderId;
    private String productName;
    private Integer productPrice;
    private Integer productStock;
    private Integer productCount;

}
