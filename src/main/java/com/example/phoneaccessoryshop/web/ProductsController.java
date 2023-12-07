package com.example.phoneaccessoryshop.web;

import com.example.phoneaccessoryshop.model.dto.AddProductDTO;
import com.example.phoneaccessoryshop.model.entity.ProductEntity;
import com.example.phoneaccessoryshop.service.CloudinaryService;
import com.example.phoneaccessoryshop.service.ModelService;
import com.example.phoneaccessoryshop.service.ProductService;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.UUID;

@Controller
public class ProductsController {

    private final ModelService modelService;
    private final ProductService productService;
    private final CloudinaryService cloudinaryService;
    private final ModelMapper modelMapper;

    public ProductsController(ModelService modelService, ProductService productService, CloudinaryService cloudinaryService, ModelMapper modelMapper) {
        this.modelService = modelService;
        this.productService = productService;
        this.cloudinaryService = cloudinaryService;
        this.modelMapper = modelMapper;
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
    public String addProducts(Model model, @RequestParam("image") MultipartFile image, @ModelAttribute("addProductDTO") @Valid AddProductDTO addProductDTO, BindingResult bindingResult) {
        String imageUrl = cloudinaryService.upload(image);
        addProductDTO.setImageUrl(imageUrl);
        productService.addProduct(addProductDTO);

        model.addAttribute("products", productService.getAllProducts());
        return "admin-add-product";
    }

    @DeleteMapping("/admin/products/delete/{productSN}")
    public String delete(@PathVariable("productSN") UUID productSN) {

        productService.deleteProduct(productSN);

        return "redirect:/admin/products";
    }

    @GetMapping("/admin/products/edit/{productSN}")
    public String editProducts(Model model, @PathVariable("productSN") UUID productSN) {
        ProductEntity product = productService.findByUUID(productSN);
        AddProductDTO editProductDTO = modelMapper.map(product, AddProductDTO.class);
        editProductDTO.setProductNumber(productSN);
        model.addAttribute("editProductDTO", editProductDTO);
        model.addAttribute("models", modelService.getAllModels());
        return "edit-product";
    }

    @PostMapping("/admin/products/edit/{productSN}")
    public String editProducts(Model model,@PathVariable("productSN") UUID productSN, @RequestParam("image") MultipartFile image, @ModelAttribute("editProductDTO") @Valid AddProductDTO editProductDTO, BindingResult bindingResult) {

        if (!image.isEmpty()) {
            String imageUrl = cloudinaryService.upload(image);
            editProductDTO.setImageUrl(imageUrl);
        }

        editProductDTO.setProductNumber(productSN);
        productService.editProduct(editProductDTO);

        return "redirect:/admin/products";
    }


}
