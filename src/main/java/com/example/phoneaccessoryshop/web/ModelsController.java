package com.example.phoneaccessoryshop.web;

import com.example.phoneaccessoryshop.model.dto.AddModelDTO;
import com.example.phoneaccessoryshop.service.BrandService;
import com.example.phoneaccessoryshop.service.ModelService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin/models")
public class ModelsController {
    private final BrandService brandService;
    private final ModelService modelService;

    public ModelsController(BrandService brandService, ModelService modelService) {
        this.brandService = brandService;
        this.modelService = modelService;
    }

    @GetMapping()
    public String addModels(Model model) {
        if (!model.containsAttribute("addModelDTO")) {
            model.addAttribute("addModelDTO", AddModelDTO.empty());
        }

        model.addAttribute("brands", brandService.getAllBrands());
        model.addAttribute("modelView", modelService.getAllModelsView());
        return "admin-add-model";
    }

    @PostMapping()
    public String addModels(@ModelAttribute("addModelDTO") @Valid AddModelDTO addModelDTO, BindingResult bindingResult) {
        modelService.addModel(addModelDTO);
        return "admin-add-model";
    }


    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id")Long id){

        modelService.deleteModel(id);

        return "redirect:/admin/models";
    }
}

