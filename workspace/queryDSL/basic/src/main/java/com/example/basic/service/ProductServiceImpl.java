package com.example.basic.service;

import com.example.basic.entity.Product;
import com.example.basic.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor // 자동 주입
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;

    @Override
    public List<Product> getList(Pageable pageable) {
        return productRepository.findAllWithPaging(pageable).getContent();
    }

    @Override
    @Transactional
    public void increasePrices() {
        productRepository.updatePrices();
    }
}
