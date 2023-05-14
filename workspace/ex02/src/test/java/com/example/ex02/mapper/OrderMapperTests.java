package com.example.ex02.mapper;

import com.example.ex02.domain.VO.OrderVO;
import com.example.ex02.domain.VO.ProductVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class OrderMapperTests {
    @Autowired
    OrderMapper orderMapper;

    @Autowired
    ProductMapper productMapper;

    @Test
    public void insertTest() {
        ProductVO productVO = null;
        OrderVO orderVO = new OrderVO();
        orderVO.setProductId(1L);
        orderVO.setProductCount(10);

        productVO = productMapper.select(orderVO.getProductId());
        productVO.setProductStock(productVO.getProductStock() - orderVO.getProductCount());

        orderMapper.insert(orderVO);
        productMapper.update(productVO);
    }

    @Test
    public void deleteTest() {


    }
}
