package com.example.phoneaccessoryshop.service.impl;

import com.example.phoneaccessoryshop.model.dto.CartViewDTO;
import com.example.phoneaccessoryshop.model.entity.CartEntity;
import com.example.phoneaccessoryshop.model.entity.CartItemEntity;
import com.example.phoneaccessoryshop.model.entity.ProductEntity;
import com.example.phoneaccessoryshop.model.entity.UserEntity;
import com.example.phoneaccessoryshop.repository.CartItemRepository;
import com.example.phoneaccessoryshop.repository.CartRepository;
import com.example.phoneaccessoryshop.service.CartService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;

@Service
public class CartServiceImpl implements CartService {

    private final CartRepository cartRepository;
    private final CartItemRepository cartItemRepository;

    public CartServiceImpl(CartRepository cartRepository, CartItemRepository cartItemRepository) {
        this.cartRepository = cartRepository;
        this.cartItemRepository = cartItemRepository;
    }

    @Override
    @Transactional
    public void addCartItem(ProductEntity product, UserEntity user) {

        CartEntity userCart = cartRepository.findByUser(user);

        if (userCart != null) {
            CartItemEntity cartItem = cartItemRepository.findByProductId(product.getUuid());
            if (cartItem != null) {
                cartItem.setQuantity(cartItem.getQuantity() + 1);
            } else {
                cartItemRepository.saveAndFlush(createCartItem(product, userCart));

            }
        } else  {
            userCart = new CartEntity();
            userCart.setCartItems(new ArrayList<>());
            userCart.setUser(user);
            cartRepository.save(userCart);
            cartItemRepository.save(createCartItem(product, userCart));
        }

    }

    @Override
    @Transactional
    public void removeCartItem(ProductEntity product, UserEntity user) {
        CartEntity userCart = cartRepository.findByUser(user);
        CartItemEntity cartItem = cartItemRepository.findByProductId(product.getUuid());

        if (cartItem.getQuantity() > 1) {
            cartItem.setQuantity(cartItem.getQuantity() - 1);
        } else {
            userCart.getCartItems().remove(cartItem);
            cartItemRepository.delete(cartItem);
        }

    }

    @Override
    public CartViewDTO getUserCart(UserEntity user) {
        CartEntity userCart = cartRepository.findByUser(user);
        return new CartViewDTO(userCart.getCartItems(), userCart.getTotalCartPrice());
    }

    public static CartItemEntity createCartItem(ProductEntity product, CartEntity cart) {
        return new CartItemEntity(cart, product.getName(), product.getImageUrl(), 1, product.getPrice(), product.getUuid());
    }


}
