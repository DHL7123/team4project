package com.evo.evoproject.repository.product;

import com.evo.evoproject.domain.product.Product;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ProductRepository {
    List<Product> findAllProducts(@Param("offset") int offset, @Param("size") int size);
    Product findProductByNo(int productNo);
    int countAllProducts();
    int countProductsByCategory(int categoryId);
    List<Product> findProductsByCategory(@Param("categoryId") int categoryId, @Param("offset") int offset, @Param("size") int size);
    void incrementProductViewCount(@Param("productNo") int productNo, @Param("count") int count);
}