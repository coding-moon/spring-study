package com.example.ex02.service;

import com.example.ex02.domain.DAO.OrderDAO;
import com.example.ex02.domain.DTO.ProductDTO;
import com.example.ex02.domain.VO.OrderVO;

import java.util.List;

public class OrderServiceImpl implements OrderService {

    private final OrderDAO orderDAO;

    @Override
    public void registerOrder(OrderVO orderVO) {
    orderDAO.add(orderVO);
    }

    @Override
    public void rigsterDelete(Long orderId) {
    orderDAO.remove(orderId);
    }


    @Override
    public ProductDTO findselect(Long orderId) {
        orderDAO.select(orderId);
    }

    @Override
    public List<ProductDTO> listGet() {
        orderDAO.findAll();
    }
}
