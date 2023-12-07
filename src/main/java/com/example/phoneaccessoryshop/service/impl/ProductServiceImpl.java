package com.example.phoneaccessoryshop.service.impl;

import com.example.phoneaccessoryshop.model.dto.ProductDTO;
import com.example.phoneaccessoryshop.model.dto.ProductSummaryDTO;
import com.example.phoneaccessoryshop.model.dto.view.ProductViewDTO;
import com.example.phoneaccessoryshop.model.entity.ProductEntity;
import com.example.phoneaccessoryshop.repository.ModelRepository;
import com.example.phoneaccessoryshop.repository.ProductRepository;
import com.example.phoneaccessoryshop.service.ProductService;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    private final ModelRepository modelRepository;
    private final ModelMapper modelMapper;


    public ProductServiceImpl(ProductRepository productRepository, ModelRepository modelRepository, ModelMapper modelMapper) {
        this.productRepository = productRepository;
        this.modelRepository = modelRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public void addProduct(ProductDTO productDTO) {

        ProductEntity product = modelMapper.map(productDTO, ProductEntity.class);
        product.setModel(modelRepository.findByName(productDTO.getModelName()));
        product.setUuid(UUID.randomUUID());
        productRepository.save(product);

    }

    @Override
    public List<ProductViewDTO> getAllProducts() {
        return productRepository.getAllProducts().stream().map(ProductServiceImpl::map).toList();
    }

    @Override
    public Page<ProductSummaryDTO> getAllProductsSummary(Pageable pageable) {
        return productRepository.findAll(pageable).map(ProductServiceImpl::mapAsSummary);
    }

    @Override
    public ProductEntity findByUUID(UUID uuid) {
        return productRepository.findByUUID(uuid);
    }

    @Override
    public Page<ProductSummaryDTO> getAllProductsSummaryByModelId(Pageable pageable, Long modelId) {

        return productRepository.findAllByModelId(modelId, pageable).map(ProductServiceImpl::mapAsSummary);
    }

    @Override
    @Transactional
    public void deleteProduct(UUID productUUID) {
        ProductEntity productDelete = productRepository.findByUUID(productUUID);
        productRepository.delete(productDelete);
    }

    @Override
    @Transactional
    public void editProduct(ProductDTO productDTO) {
        ProductEntity product = productRepository.findByUUID(productDTO.getProductUUID());
        product.setName(productDTO.getName());
        product.setDescription(productDTO.getDescription());
        product.setColor(productDTO.getColor());
        product.setPrice(productDTO.getPrice());
        product.setDiscountPrice(productDTO.getDiscountPrice());
        product.setDiscountStartDate(productDTO.getDiscountStartDate());
        product.setDiscountEndDate(productDTO.getDiscountEndDate());
        product.setQuantity(productDTO.getQuantity());
        if (!(productDTO.getImageUrl() == null)) {
            product.setImageUrl(productDTO.getImageUrl());
        }

    }

    private static ProductSummaryDTO mapAsSummary(ProductEntity product) {
        return new ProductSummaryDTO(product.getName(), product.getUuid().toString(), product.getPrice(), product.getDiscountPrice(), product.getImageUrl());
    }

    private static ProductViewDTO map(ProductEntity product) {
        return new ProductViewDTO(product.getModel().getBrand().getName(), product.getModel().getName(), product.getName(), product.getUuid(), product.getQuantity());
    }
}
