package com.example.phoneaccessoryshop.repository;

import com.example.phoneaccessoryshop.model.entity.PhoneBrandEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BrandRepository extends JpaRepository<PhoneBrandEntity, Long> {
    @Query("SELECT b FROM PhoneBrandEntity b")
    List<PhoneBrandEntity> getAllBrands();

    PhoneBrandEntity findByName(String brandName);

}
