package com.example.phoneaccessoryshop.service;

import com.example.phoneaccessoryshop.model.dto.DeliveryAddressDTO;

import java.security.Principal;

public interface OrdersService {
    void placeOrder(DeliveryAddressDTO deliveryAddressDTO, Principal principal);
}
