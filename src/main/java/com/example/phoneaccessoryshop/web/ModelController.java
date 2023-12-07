package com.example.phoneaccessoryshop.web;

import com.example.phoneaccessoryshop.model.dto.ModelDTO;
import com.example.phoneaccessoryshop.service.BrandService;
import com.example.phoneaccessoryshop.service.ModelService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin/models")
public class ModelController {
    private final BrandService brandService;
    private final ModelService modelService;

    public ModelController(BrandService brandService, ModelService modelService) {
        this.brandService = brandService;
        this.modelService = modelService;
    }

    @GetMapping()
    public String addModel(Model model) {
        if (!model.containsAttribute("ModelDTO")) {
            model.addAttribute("ModelDTO", ModelDTO.empty());
        }

        model.addAttribute("brands", brandService.getAllBrands());
        model.addAttribute("modelViews", modelService.getAllModelViews());
        return "admin-model";
    }

    @PostMapping()
    public String addModel(@ModelAttribute("ModelDTO") @Valid ModelDTO modelDTO, BindingResult bindingResult) {
        modelService.addModel(modelDTO);
        return "admin-model";
    }


    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id")Long id){

        modelService.deleteModel(id);

        return "redirect:/admin/models";
    }
}

