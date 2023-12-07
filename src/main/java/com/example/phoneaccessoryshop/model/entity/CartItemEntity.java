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
    private String productName;
    private String productImageURL;
    private int itemQuantity;
    private BigDecimal productPrice;
    private UUID productUUID;

    public CartItemEntity(CartEntity cart, String productName, String productImageURL, int itemQuantity, BigDecimal productPrice, UUID productUUID) {
        this.cart = cart;
        this.productName = productName;
        this.productImageURL = productImageURL;
        this.itemQuantity = itemQuantity;
        this.productPrice = productPrice;
        this.productUUID = productUUID;
    }

    public CartItemEntity() {

    }

    public BigDecimal totalItemPrice() {
        return productPrice.multiply(BigDecimal.valueOf(itemQuantity));
    }

    public CartEntity getCart() {
        return cart;
    }

    public void setCart(CartEntity cart) {
        this.cart = cart;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String name) {
        this.productName = name;
    }

    public String getProductImageURL() {
        return productImageURL;
    }

    public void setProductImageURL(String imageUrl) {
        this.productImageURL = imageUrl;
    }

    public int getItemQuantity() {
        return itemQuantity;
    }

    public void setItemQuantity(int quantity) {
        this.itemQuantity = quantity;
    }

    public BigDecimal getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(BigDecimal price) {
        this.productPrice = price;
    }

    public UUID getProductUUID() {
        return productUUID;
    }

    public void setProductUUID(UUID productId) {
        this.productUUID = productId;
    }
}
