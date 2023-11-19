package com.example.phoneaccessoryshop.repository;

import com.example.phoneaccessoryshop.model.entity.PhoneBrandEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BrandRepository extends JpaRepository<PhoneBrandEntity, Long> {
}
