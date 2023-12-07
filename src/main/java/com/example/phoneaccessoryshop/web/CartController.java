package com.example.phoneaccessoryshop.web;

import com.example.phoneaccessoryshop.model.entity.ProductEntity;
import com.example.phoneaccessoryshop.model.entity.UserEntity;
import com.example.phoneaccessoryshop.service.CartService;
import com.example.phoneaccessoryshop.service.ProductService;
import com.example.phoneaccessoryshop.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.security.Principal;
import java.util.UUID;

@Controller
public class CartController {
    private final CartService cartService;
    private final ProductService productService;
    private final UserService userService;

    public CartController(CartService cartService, ProductService productService, UserService userService) {
        this.cartService = cartService;
        this.productService = productService;
        this.userService = userService;
    }


    @GetMapping("/cart")
    public String login(Model model, Principal principal) {
        String email = principal.getName();
        model.addAttribute("cartInfo", cartService.getUserCart(userService.findByName(email)));
        return "cart";
    }

    @PostMapping("/cart/add/{productNumber}")
    public String addToCart(@PathVariable("productNumber") UUID uuid, Principal principal) {
        ProductEntity product = productService.findByUUID(uuid);
        String email = principal.getName();
        UserEntity user = userService.findByName(email);
        cartService.addCartItem(product, user);
        return "redirect:/cart";
    }

    @DeleteMapping("/cart/remove/{productNumber}")
    public String removeFromCart(@PathVariable("productNumber") UUID uuid, Principal principal) {
        ProductEntity product = productService.findByUUID(uuid);
        String email = principal.getName();
        UserEntity user = userService.findByName(email);
        cartService.removeCartItem(product, user);
        return "redirect:/cart";
    }


}
