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
public class BrandsController {
    private final BrandService brandService;

    public BrandsController(BrandService brandService) {
        this.brandService = brandService;
    }

    @GetMapping()
    public String addBrands(Model model, @ModelAttribute("addBrandDTO") BrandDTO addBrandDTO) {
        model.addAttribute("brandView", brandService.getAllBrandsView());
        return "admin-add-brand";
    }

    @PostMapping()
    public String addBrands(Model model, @ModelAttribute("addBrandDTO") @Valid BrandDTO addBrandDTO, BindingResult bindingResult) {
        brandService.addBrand(addBrandDTO);
        model.addAttribute("brandView", brandService.getAllBrandsView());
        return "admin-add-brand";
    }
    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") Long id) {

        brandService.deleteBrand(id);

        return "redirect:/admin/brands";
    }
}
