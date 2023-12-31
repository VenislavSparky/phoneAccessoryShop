package com.example.phoneaccessoryshop.model.dto.view;

import com.example.phoneaccessoryshop.model.entity.CartItemEntity;

import java.math.BigDecimal;
import java.util.List;

public record CartViewDTO(List<CartItemEntity> cartItems,BigDecimal totalCartPrice) {

}
