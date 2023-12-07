package com.example.phoneaccessoryshop.model.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "carts")
public class CartEntity extends BaseEntity {


    @OneToMany(
            fetch = FetchType.EAGER,
            mappedBy = "cart", cascade = CascadeType.REMOVE)
    private List<CartItemEntity> cartItems;

    @OneToOne
    private UserEntity user;

    private BigDecimal totalCartPrice;

    public List<CartItemEntity> getCartItems() {
        return cartItems;
    }

    public void setCartItems(List<CartItemEntity> cartItems) {
        this.cartItems = cartItems;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    public BigDecimal getTotalCartPrice() {
        return getCartItems().stream().map(CartItemEntity::totalItemPrice).reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public void setTotalCartPrice() {
        this.totalCartPrice = getTotalCartPrice();
    }
}
