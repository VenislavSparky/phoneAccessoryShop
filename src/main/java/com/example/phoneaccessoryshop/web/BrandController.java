package com.example.phoneaccessoryshop.web;

import com.example.phoneaccessoryshop.model.dto.BrandDTO;
import com.example.phoneaccessoryshop.service.BrandService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin/brands")
public class BrandController {
    private final BrandService brandService;

    public BrandController(BrandService brandService) {
        this.brandService = brandService;
    }

    @GetMapping()
    public String addBrand(Model model, @ModelAttribute("BrandDTO") BrandDTO brandDTO) {
        model.addAttribute("brandView", brandService.getAllBrandViews());
        return "admin-brand";
    }

    @PostMapping()
    public String addBrand(Model model, @ModelAttribute("BrandDTO") @Valid BrandDTO brandDTO, BindingResult bindingResult) {
        brandService.addBrand(brandDTO);
        model.addAttribute("brandView", brandService.getAllBrandViews());
        return "admin-brand";
    }
    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") Long id) {

        brandService.deleteBrand(id);

        return "redirect:/admin/brands";
    }
}
