package com.example.phoneaccessoryshop.web;

import com.example.phoneaccessoryshop.model.dto.BrandDTO;
import com.example.phoneaccessoryshop.model.dto.AddModelDTO;
import com.example.phoneaccessoryshop.model.dto.AddProductDTO;
import com.example.phoneaccessoryshop.service.BrandService;
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
public class AdminPanelController {

    private final BrandService brandService;
    private final ModelService modelService;
    private final ProductService productService;

    public AdminPanelController(BrandService brandService, ModelService modelService, ProductService productService) {
        this.brandService = brandService;
        this.modelService = modelService;
        this.productService = productService;
    }

    @GetMapping("/admin/panel")
    public String adminPanel() {
        return "admin-panel";
    }

    @GetMapping("/admin/brands")
    public String addBrands(@ModelAttribute("addBrandDTO") BrandDTO addBrandDTO) {
        return "admin-add-brand";
    }

    @PostMapping("/admin/brands")
    public String addBrands(@ModelAttribute("addBrandDTO") @Valid BrandDTO addBrandDTO, BindingResult bindingResult) {

        brandService.addBrand(addBrandDTO);

        return "admin-add-brand";
    }

    @GetMapping("/admin/models")
    public String addModels(Model model) {
        if (!model.containsAttribute("addModelDTO")) {
            model.addAttribute("addModelDTO", AddModelDTO.empty());
        }

        model.addAttribute("brands", brandService.getAllBrands());
        return "admin-add-model";
    }

    @PostMapping("/admin/models")
    public String addModels(@ModelAttribute("addModelDTO") @Valid AddModelDTO addModelDTO, BindingResult bindingResult) {
       modelService.addModel(addModelDTO);
        return "admin-add-model";
    }

    @GetMapping("/admin/products")
    public String addProducts(@ModelAttribute("addProductDTO") AddProductDTO addProductDTO) {
        return "admin-add-product";
    }

    @PostMapping("/admin/products")
    public String addProducts(@ModelAttribute("addProductDTO") @Valid AddProductDTO addProductDTO, BindingResult bindingResult) {
        productService.addProduct(addProductDTO);
        return "admin-add-product";
    }
}
