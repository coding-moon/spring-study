package com.example.ex03.service;

import com.example.ex03.domain.dao.ProductDAO;
import com.example.ex03.domain.vo.ProductVO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

@Service @Qualifier("product") @Primary
@RequiredArgsConstructor
public class ProductService {
    private final ProductDAO productDAO;

    //상품 등록
    public void registerProduct(ProductVO productVO) { productDAO.save(productVO);}

    // 상품 수정
    public void updateProduct(ProductVO productVO) { productDAO.setProductVO(productVO);}

    //상품 조회
    public ProductVO getProduct(Long productId) {
        return productDAO.findById(productId);
    }

    // 상품 목록
    public List<ProductVO> getList() { return productDAO.findAll();}
}


//@RequestBody - 화면에 json으로 데이터 보내줘야함 그냥은 json으로 전송이 안됨 매핑안됨