package com.example.phoneaccessoryshop.web;

import com.example.phoneaccessoryshop.model.dto.DeliveryAddressDTO;
import com.example.phoneaccessoryshop.service.OrdersService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.security.Principal;

@Controller
public class OrderController {

    private final OrdersService ordersService;

    public OrderController(OrdersService ordersService) {
        this.ordersService = ordersService;
    }

    @GetMapping("/order")
    public String order(Model model, @ModelAttribute("deliveryAddressDTO") DeliveryAddressDTO deliveryAddressDTO) {
        return "order";
    }

    @PostMapping("/order/place")
    public String placeOrder(Model model, @ModelAttribute("deliveryAddressDTO") DeliveryAddressDTO deliveryAddressDTO, Principal principal) {
        ordersService.placeOrder(deliveryAddressDTO, principal);
        return "order";
    }

}
