package com.example.ex03.controller;


import com.example.ex03.domain.vo.ProductVO;
import com.example.ex03.service.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequiredArgsConstructor(/*prodcut*/)
public class ProductController {
    private final ProductService productService;

    @PostMapping("/products")
    public String pro1() {
        ProductVO productVO = new ProductVO();

        productService.registerProduct(productVO);
        return

    }
}

