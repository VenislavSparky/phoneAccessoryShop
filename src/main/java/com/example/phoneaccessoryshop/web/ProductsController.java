package com.example.phoneaccessoryshop.web;

import com.example.phoneaccessoryshop.model.dto.AddProductDTO;
import com.example.phoneaccessoryshop.service.ModelService;
import com.example.phoneaccessoryshop.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ProductsController {

    private final ModelService modelService;
    private final ProductService productService;

    public ProductsController(ModelService modelService, ProductService productService) {
        this.modelService = modelService;
        this.productService = productService;
    }

    @GetMapping("/admin/products")
    public String addProducts(Model model) {
        if (!model.containsAttribute("addProductDTO")) {
            model.addAttribute("addProductDTO", AddProductDTO.empty());
        }
        model.addAttribute("models", modelService.getAllModels());
        model.addAttribute("products", productService.getAllProducts());
        return "admin-add-product";
    }

    @PostMapping("/admin/products")
    public String addProducts(Model model, @ModelAttribute("addProductDTO") @Valid AddProductDTO addProductDTO, BindingResult bindingResult) {
        productService.addProduct(addProductDTO);
        model.addAttribute("products", productService.getAllProducts());
        return "admin-add-product";
    }
}
