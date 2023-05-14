package com.example.ex02.domain.DAO;

import com.example.ex02.domain.DTO.ProductDTO;
import com.example.ex02.domain.VO.OrderVO;
import com.example.ex02.mapper.OrderMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class OrderDAO {
    private final OrderMapper orderMapper;

    //    추가
    public void add(OrderVO orderVO) {
        orderMapper.insert(orderVO);
    }
    //    삭제
    public void remove(Long orderId) {
        orderMapper.delete(orderId);
    }

    //    조회(총 결제 금액까지)
    public ProductDTO select(Long orderId) {
      return  orderMapper.select(orderId);
    }

    //    목록(총 결제 금액까지)
    public List<ProductDTO> findAll() {
       return orderMapper.selectAll();
    }
}
