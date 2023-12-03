package com.example.phoneaccessoryshop.web;


import com.example.phoneaccessoryshop.model.dto.ProductSummaryDTO;
import com.example.phoneaccessoryshop.model.entity.ProductEntity;
import com.example.phoneaccessoryshop.model.entity.UserEntity;
import com.example.phoneaccessoryshop.service.CartService;
import com.example.phoneaccessoryshop.service.ProductService;
import com.example.phoneaccessoryshop.service.UserService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.security.Principal;
import java.util.UUID;

@Controller
public class ShopController {

    private final ProductService productService;
    private final CartService cartService;
    private final UserService userService;

    public ShopController(ProductService productService, CartService cartService, UserService userService) {
        this.productService = productService;
        this.cartService = cartService;
        this.userService = userService;
    }

    @GetMapping("/shop/products/{pageNumber}")
    public String shopProducts(Model model, @PageableDefault(
            size = 6,
            sort = "uuid"
    ) Pageable pageable, @PathVariable("pageNumber") int pageNumber) {
        Page<ProductSummaryDTO> allProductsSummary = productService.getAllProductsSummary(pageable.withPage(pageNumber));
        model.addAttribute("allProductsSummary", allProductsSummary);
        return "shop";
    }

    @GetMapping("/shop/products/next")
    public String nextPage(Model model, @PageableDefault(
            size = 6,
            sort = "uuid"
    ) Pageable pageable) {
Pageable pageableMove = PageRequest.of(3,6);
        Page<ProductSummaryDTO> allProductsSummary = productService.getAllProductsSummary(pageableMove);
        model.addAttribute("allProductsSummary", allProductsSummary);
        return "shop";
    }

    @GetMapping("/shop/products/prev")
    public String prevPage(Model model, @PageableDefault(
            size = 6,
            sort = "uuid"
    ) Pageable pageable) {


        Page<ProductSummaryDTO> allProductsSummary = productService.getAllProductsSummary(pageable);
        model.addAttribute("allProductsSummary", allProductsSummary);
        return "shop";
    }

    @PostMapping("/shop/cart/add/{productNumber}")
    public String addToCart(@PathVariable("productNumber") UUID uuid, Principal principal) {
        ProductEntity product = productService.findByUUID(uuid);
        String email = principal.getName();
        UserEntity user = userService.findByName(email);
        cartService.addCartItem(product, user);
        return "redirect:/shop/products/0";
    }

}
