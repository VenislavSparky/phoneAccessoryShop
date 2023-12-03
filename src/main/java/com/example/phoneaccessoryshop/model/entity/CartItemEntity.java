package com.example.phoneaccessoryshop.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Table(name = "cart_items")
public class CartItemEntity extends BaseEntity {
    @ManyToOne
    private CartEntity cart;
    private String name;
    private String imageUrl;
    private int quantity;
    private BigDecimal price;
    private UUID productId;

    public CartItemEntity(CartEntity cart, String name, String imageUrl, int quantity, BigDecimal price, UUID productId) {
        this.cart = cart;
        this.name = name;
        this.imageUrl = imageUrl;
        this.quantity = quantity;
        this.price = price;
        this.productId = productId;
    }

    public CartItemEntity() {

    }

    public BigDecimal totalItemPrice() {
        return price.multiply(BigDecimal.valueOf(quantity));
    }


    public CartEntity getCart() {
        return cart;
    }

    public void setCart(CartEntity cart) {
        this.cart = cart;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public UUID getProductId() {
        return productId;
    }

    public void setProductId(UUID productId) {
        this.productId = productId;
    }
}
