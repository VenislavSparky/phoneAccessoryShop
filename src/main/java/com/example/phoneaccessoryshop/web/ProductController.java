package com.example.phoneaccessoryshop.web;

import com.example.phoneaccessoryshop.model.dto.ProductDTO;
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
public class ProductController {

    private final ModelService modelService;
    private final ProductService productService;
    private final CloudinaryService cloudinaryService;
    private final ModelMapper modelMapper;

    public ProductController(ModelService modelService, ProductService productService, CloudinaryService cloudinaryService, ModelMapper modelMapper) {
        this.modelService = modelService;
        this.productService = productService;
        this.cloudinaryService = cloudinaryService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/admin/products")
    public String addProduct(Model model) {
        if (!model.containsAttribute("ProductDTO")) {
            model.addAttribute("ProductDTO", ProductDTO.empty());
        }
        model.addAttribute("models", modelService.getAllModels());
        model.addAttribute("products", productService.getAllProducts());
        return "admin-product";
    }

    @PostMapping("/admin/products")
    public String addProduct(Model model, @RequestParam("image") MultipartFile image, @ModelAttribute("addProductDTO") @Valid ProductDTO productDTO, BindingResult bindingResult) {
        String imageUrl = cloudinaryService.upload(image);
        productDTO.setImageUrl(imageUrl);
        productService.addProduct(productDTO);

        model.addAttribute("products", productService.getAllProducts());
        return "admin-product";
    }

    @DeleteMapping("/admin/products/delete/{productUUID}")
    public String deleteProduct(@PathVariable("productUUID") UUID productUUID) {

        productService.deleteProduct(productUUID);

        return "redirect:/admin/products";
    }

    @GetMapping("/admin/products/edit/{productUUID}")
    public String editProduct(Model model, @PathVariable("productUUID") UUID productUUID) {
        ProductEntity product = productService.findByUUID(productUUID);
        ProductDTO productDTO = modelMapper.map(product, ProductDTO.class);
        productDTO.setProductUUID(productUUID);
        model.addAttribute("productDTO", productDTO);
        model.addAttribute("models", modelService.getAllModels());
        return "edit-product";
    }

    @PostMapping("/admin/products/edit/{productUUID}")
    public String editProduct(@PathVariable("productUUID") UUID productUUID, @RequestParam("image") MultipartFile image, @ModelAttribute("editProductDTO") @Valid ProductDTO productDTO, BindingResult bindingResult) {

        if (!image.isEmpty()) {
            String imageUrl = cloudinaryService.upload(image);
            productDTO.setImageUrl(imageUrl);
        }

        productDTO.setProductUUID(productUUID);
        productService.editProduct(productDTO);

        return "redirect:/admin/products";
    }


}
