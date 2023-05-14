package com.example.ex02.domain.VO;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class OrderVO {
    private Long orderId;
    private Long productId;
    private Integer productCount;
    private String orderDate;
}
