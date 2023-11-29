package com.example.phoneaccessoryshop.service;

import com.example.phoneaccessoryshop.model.dto.AddProductDTO;
import com.example.phoneaccessoryshop.model.dto.ProductViewDTO;

import java.util.List;

public interface ProductService {
    void addProduct(AddProductDTO addProductDTO);

    List<ProductViewDTO> getAllProducts();
}
