package com.example.phoneaccessoryshop.repository;

import com.example.phoneaccessoryshop.model.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.UUID;

public interface ProductRepository extends JpaRepository<ProductEntity, Long> {
    @Query("SELECT p FROM ProductEntity p")
    List<ProductEntity> getAllProducts();
    @Query("SELECT p FROM ProductEntity p WHERE p.uuid = :uuid")
    ProductEntity findByUUID(@Param("uuid") UUID uuid);

}
