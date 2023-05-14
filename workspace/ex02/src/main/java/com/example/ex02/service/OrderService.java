package com.example.ex02.service;


import com.example.ex02.domain.DTO.ProductDTO;
import com.example.ex02.domain.VO.OrderVO;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderService {

    public void registerOrder(OrderVO orderVO);

    //    삭제
    public void rigsterDelete(Long orderId);

    //    조회(총 결제 금액까지)
    public ProductDTO findselect(Long orderId);

    //    목록(총 결제 금액까지)
    public List<ProductDTO> listGet();
}
