package com.example.phoneaccessoryshop.service.impl;

import com.example.phoneaccessoryshop.model.dto.DeliveryAddressDTO;
import com.example.phoneaccessoryshop.model.entity.CartEntity;
import com.example.phoneaccessoryshop.model.entity.DeliveryAddressEntity;
import com.example.phoneaccessoryshop.model.entity.OrderEntity;
import com.example.phoneaccessoryshop.model.entity.UserEntity;
import com.example.phoneaccessoryshop.model.enums.OrderStatusEnum;
import com.example.phoneaccessoryshop.repository.CartRepository;
import com.example.phoneaccessoryshop.repository.DeliveryAddressRepository;
import com.example.phoneaccessoryshop.repository.OrderRepository;
import com.example.phoneaccessoryshop.repository.UserRepository;
import com.example.phoneaccessoryshop.service.OrdersService;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.Optional;

@Service
public class OrdersServiceImpl implements OrdersService {

    private final DeliveryAddressRepository deliveryAddressRepository;
    private final OrderRepository orderRepository;
    private final UserRepository userRepository;
    private final CartRepository cartRepository;
    private final ModelMapper modelMapper;


    public OrdersServiceImpl(DeliveryAddressRepository deliveryAddressRepository, OrderRepository orderRepository, UserRepository userRepository, CartRepository cartRepository, ModelMapper modelMapper) {
        this.deliveryAddressRepository = deliveryAddressRepository;
        this.orderRepository = orderRepository;
        this.userRepository = userRepository;
        this.cartRepository = cartRepository;
        this.modelMapper = modelMapper;
    }


    @Override
    @Transactional
    public void placeOrder(DeliveryAddressDTO deliveryAddressDTO, Principal principal) {
        DeliveryAddressEntity deliveryAddress = deliveryAddressRepository.save(modelMapper.map(deliveryAddressDTO, DeliveryAddressEntity.class));
        UserEntity user = userRepository.findByEmail(principal.getName()).orElse(null);
        CartEntity cart = cartRepository.findByUser(user);
        OrderEntity order = new OrderEntity(deliveryAddress, cart, OrderStatusEnum.AWAITING_APPROVAL);
        orderRepository.save(order);
        cart.setUser(null);
    }
}
