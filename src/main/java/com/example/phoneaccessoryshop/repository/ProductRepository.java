package com.example.phoneaccessoryshop.repository;

import com.example.phoneaccessoryshop.model.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductRepository extends JpaRepository<ProductEntity, Long> {
    @Query("SELECT p FROM ProductEntity p")
    List<ProductEntity> getAllProducts();
}
