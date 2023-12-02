package com.example.phoneaccessoryshop.web;


import com.example.phoneaccessoryshop.model.dto.ProductSummaryDTO;
import com.example.phoneaccessoryshop.service.ProductService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;

@Controller
public class ShopController {

    private final ProductService productService;

    public ShopController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/shop/products")
    public String shopProducts(Model model, @PageableDefault(
            size = 6,
            sort = "uuid"
    ) Pageable pageable) {
        Page<ProductSummaryDTO> allProductsSummary = productService.getAllProductsSummary(pageable);
        model.addAttribute("allProductsSummary", allProductsSummary);
        return "shop";
    }

}
