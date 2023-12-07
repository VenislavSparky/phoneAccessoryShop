package com.example.phoneaccessoryshop.service.impl;

import com.example.phoneaccessoryshop.model.dto.view.CartViewDTO;
import com.example.phoneaccessoryshop.model.entity.CartEntity;
import com.example.phoneaccessoryshop.model.entity.CartItemEntity;
import com.example.phoneaccessoryshop.model.entity.ProductEntity;
import com.example.phoneaccessoryshop.model.entity.UserEntity;
import com.example.phoneaccessoryshop.repository.CartItemRepository;
import com.example.phoneaccessoryshop.repository.CartRepository;
import com.example.phoneaccessoryshop.service.CartService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
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

        CartEntity cart = cartRepository.findByUser(user);

        if (cart == null) {
            cart = new CartEntity();
            cart.setCartItems(new ArrayList<>());
            cart.setUser(user);
            cartRepository.save(cart);
        }

        CartItemEntity cartItem = cartItemRepository.findByCartIdAndProductUUID(cart.getId(),product.getUuid());

        if (cartItem == null) {
            cartItemRepository.save(createCartItem(product, cart));
        }else {
            cartItem.setItemQuantity(cartItem.getItemQuantity() + 1);
        }

    }

    @Override
    @Transactional
    public void removeCartItem(ProductEntity product, UserEntity user) {
        CartEntity cart = cartRepository.findByUser(user);
        CartItemEntity cartItem = cartItemRepository.findByCartIdAndProductUUID(cart.getId(),product.getUuid());

        if (cartItem.getItemQuantity() > 1) {
            cartItem.setItemQuantity(cartItem.getItemQuantity() - 1);
        } else {
            cart.getCartItems().remove(cartItem);
            cartItemRepository.delete(cartItem);
        }

    }

    @Override
    public CartViewDTO getUserCart(UserEntity user) {
        CartEntity cart = cartRepository.findByUser(user);

        if (cart == null) {
            cart = new CartEntity();
            cart.setCartItems(new ArrayList<>());
            cart.setUser(user);
            cartRepository.save(cart);
        }

        return new CartViewDTO(cart.getCartItems(), cart.getTotalCartPrice());
    }

    public static CartItemEntity createCartItem(ProductEntity product, CartEntity cart) {
        return new CartItemEntity(cart, product.getName(), product.getImageUrl(), 1, product.getPrice(), product.getUuid());
    }


}
