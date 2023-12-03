package com.example.phoneaccessoryshop.service;

import com.example.phoneaccessoryshop.model.dto.AddProductDTO;
import com.example.phoneaccessoryshop.model.dto.ProductSummaryDTO;
import com.example.phoneaccessoryshop.model.dto.ProductViewDTO;
import com.example.phoneaccessoryshop.model.entity.ProductEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.UUID;

public interface ProductService {
    void addProduct(AddProductDTO addProductDTO);

    List<ProductViewDTO> getAllProducts();

    Page<ProductSummaryDTO> getAllProductsSummary(Pageable pageable);

    ProductEntity findByUUID(UUID uuid);
}
