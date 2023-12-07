package com.example.phoneaccessoryshop.model.entity;

import com.example.phoneaccessoryshop.model.enums.OrderStatusEnum;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "orders")
public class OrderEntity extends BaseEntity {

    @NotNull
    String email;

    @OneToOne
    DeliveryAddressEntity deliveryAddress;

    @OneToOne(cascade = CascadeType.ALL)
    CartEntity cart;

    @Enumerated(value = EnumType.ORDINAL)
    OrderStatusEnum statusEnum;

    public OrderEntity(String email, DeliveryAddressEntity deliveryAddress, CartEntity cart, OrderStatusEnum statusEnum) {
        this.email = email;
        this.deliveryAddress = deliveryAddress;
        this.cart = cart;
        this.statusEnum = statusEnum;
    }

    public OrderEntity() {
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public DeliveryAddressEntity getDeliveryAddress() {
        return deliveryAddress;
    }

    public void setDeliveryAddress(DeliveryAddressEntity deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }

    public CartEntity getCart() {
        return cart;
    }

    public void setCart(CartEntity cart) {
        this.cart = cart;
    }

    public OrderStatusEnum getStatusEnum() {
        return statusEnum;
    }

    public void setStatusEnum(OrderStatusEnum statusEnum) {
        this.statusEnum = statusEnum;
    }
}
