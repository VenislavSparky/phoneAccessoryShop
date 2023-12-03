package com.example.phoneaccessoryshop.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "orders")
public class OrderEntity extends BaseEntity {

    @OneToOne
    DeliveryAddressEntity deliveryAddress;

    @OneToOne
    CartEntity cart;

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
}
