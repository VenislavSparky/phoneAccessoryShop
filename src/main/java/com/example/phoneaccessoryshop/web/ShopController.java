package com.example.phoneaccessoryshop.web;


import com.example.phoneaccessoryshop.model.dto.ProductSummaryDTO;
import com.example.phoneaccessoryshop.model.entity.ProductEntity;
import com.example.phoneaccessoryshop.model.entity.UserEntity;
import com.example.phoneaccessoryshop.service.CartService;
import com.example.phoneaccessoryshop.service.ModelService;
import com.example.phoneaccessoryshop.service.ProductService;
import com.example.phoneaccessoryshop.service.UserService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

import java.security.Principal;
import java.util.UUID;

@Controller
public class ShopController {

    private final ProductService productService;
    private final CartService cartService;
    private final UserService userService;
    private final ModelService modelService;

    public ShopController(ProductService productService, CartService cartService, UserService userService, ModelService modelService) {
        this.productService = productService;
        this.cartService = cartService;
        this.userService = userService;
        this.modelService = modelService;
    }

    @GetMapping("/shop/products/")
    public String shopProducts(Model model, @RequestParam(name = "searchBy", defaultValue = "") String searchBy, @RequestParam(name = "sortOption", defaultValue = "uuid") String sortOption, @RequestParam(name = "page", defaultValue = "1") int page) {

        model.addAttribute("models", modelService.getAllModels());
        getPage(model, searchBy, page, sortOption);

        return "shop";
    }


    private void getPage(Model model, String searchByModel, int page, String sortOption) {

        Sort sort = Sort.by(sortOption);

        Pageable pageable = PageRequest.of(page - 1, 15, sort);

        Page<ProductSummaryDTO> allProductsSummary;

        if (searchByModel.isEmpty()) {
            allProductsSummary = productService.getAllProductsSummary(pageable);
        } else {
            Long modelId = modelService.findModelIdByName(searchByModel);
            allProductsSummary = productService.getAllProductsSummaryByName(pageable,modelId);
        }

        model.addAttribute("models", modelService.getAllModels());
        model.addAttribute("allProductsSummary", allProductsSummary);
        model.addAttribute("currentPage", pageable.getPageNumber() + 1);
        model.addAttribute("currentSort", sortOption);
        model.addAttribute("currentModel", searchByModel);
        model.addAttribute("totalPages", allProductsSummary.getTotalPages());
    }


    @PostMapping("/shop/cart/add/{productNumber}")
    public String addToCart(@PathVariable("productNumber") UUID uuid, Principal principal) {
        ProductEntity product = productService.findByUUID(uuid);
        String email = principal.getName();
        UserEntity user = userService.findByName(email);
        cartService.addCartItem(product, user);
        return "redirect:/shop/products/";
    }

}
