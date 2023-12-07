package com.example.phoneaccessoryshop.repository;

import com.example.phoneaccessoryshop.model.entity.BrandEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BrandRepository extends JpaRepository<BrandEntity, Long> {
    @Query("SELECT b FROM BrandEntity b")
    List<BrandEntity> getAllBrands();
    BrandEntity findByName(String brandName);

}
