package com.example.phoneaccessoryshop.repository;

import com.example.phoneaccessoryshop.model.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<ProductEntity, Long> {
}
