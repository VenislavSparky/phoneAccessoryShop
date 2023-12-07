package com.example.phoneaccessoryshop.repository;

import com.example.phoneaccessoryshop.model.entity.DeliveryAddressEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeliveryAddressRepository extends JpaRepository<DeliveryAddressEntity, Long> {
}
