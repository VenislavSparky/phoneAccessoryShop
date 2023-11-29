package com.example.phoneaccessoryshop.repository;

import com.example.phoneaccessoryshop.model.entity.PhoneModelEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ModelRepository extends JpaRepository<PhoneModelEntity, Long> {
    @Query("SELECT m FROM PhoneModelEntity m")
    List<PhoneModelEntity> getAllModels();

    PhoneModelEntity findByName(String modelName);
}
