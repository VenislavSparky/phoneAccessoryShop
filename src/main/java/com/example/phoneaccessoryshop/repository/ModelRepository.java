package com.example.phoneaccessoryshop.repository;

import com.example.phoneaccessoryshop.model.entity.ModelEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ModelRepository extends JpaRepository<ModelEntity, Long> {
    @Query("SELECT m FROM ModelEntity m")
    List<ModelEntity> getAllModels();
    ModelEntity findByName(String name);
}
