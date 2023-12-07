package com.example.phoneaccessoryshop.service;

import com.example.phoneaccessoryshop.model.dto.ProductDTO;
import com.example.phoneaccessoryshop.model.dto.ProductSummaryDTO;
import com.example.phoneaccessoryshop.model.dto.view.ProductViewDTO;
import com.example.phoneaccessoryshop.model.entity.ProductEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.UUID;

public interface ProductService {
    void addProduct(ProductDTO productDTO);

    List<ProductViewDTO> getAllProducts();

    Page<ProductSummaryDTO> getAllProductsSummary(Pageable pageable);

    ProductEntity findByUUID(UUID uuid);

    Page<ProductSummaryDTO> getAllProductsSummaryByModelId(Pageable pageable, Long modelId);

    void deleteProduct(UUID productSN);

    void editProduct(ProductDTO productDTO);
}
