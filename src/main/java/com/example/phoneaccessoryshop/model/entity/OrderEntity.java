package com.example.phoneaccessoryshop.model.entity;

import com.example.phoneaccessoryshop.model.enums.OrderStatusEnum;
import jakarta.persistence.*;

@Entity
@Table(name = "orders")
public class OrderEntity extends BaseEntity {

    @OneToOne
    DeliveryAddressEntity deliveryAddress;


    @OneToOne(cascade = CascadeType.ALL)
    CartEntity cart;



    @Enumerated(value = EnumType.ORDINAL)
    OrderStatusEnum statusEnum;

    public OrderEntity(DeliveryAddressEntity deliveryAddress, CartEntity cart, OrderStatusEnum statusEnum) {
        this.deliveryAddress = deliveryAddress;
        this.cart = cart;
        this.statusEnum = statusEnum;
    }

    public OrderEntity() {
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
