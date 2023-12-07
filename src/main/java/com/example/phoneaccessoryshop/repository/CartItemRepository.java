package com.example.phoneaccessoryshop.repository;

import com.example.phoneaccessoryshop.model.entity.CartItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CartItemRepository extends JpaRepository<CartItemEntity, Long> {
    CartItemEntity findByCartIdAndProductId(Long cartId, UUID productId);
}
