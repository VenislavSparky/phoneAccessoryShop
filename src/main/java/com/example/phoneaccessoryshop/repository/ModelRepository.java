package com.example.phoneaccessoryshop.repository;

import com.example.phoneaccessoryshop.model.entity.PhoneModelEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ModelRepository extends JpaRepository<PhoneModelEntity, Long> {
}
