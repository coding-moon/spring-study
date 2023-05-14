package com.example.ex03.domain.dto;

import lombok.Data;
import org.springframework.stereotype.Component;


    @Component
    @Data
    public class OrderDTO {
        private Long productId;
        private Long orderId;
        private String productName;
        private Integer productPrice;
        private Integer productStock;
        private Integer productCount;

    }





