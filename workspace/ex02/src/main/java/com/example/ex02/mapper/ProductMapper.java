package com.example.ex02.mapper;

import com.example.ex02.domain.VO.ProductVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ProductMapper {
    // 상품추가
    public void insert(ProductVO productVO);

    // 상품수정
    public void update(ProductVO productVO);

    // 상품 조회
    public String select(ProductVO productVO);

    // 상품목록
    public List<ProductVO> selectAll();


}
