package com.example.phoneaccessoryshop.service.impl;

import com.example.phoneaccessoryshop.model.dto.AddProductDTO;
import com.example.phoneaccessoryshop.model.dto.ProductViewDTO;
import com.example.phoneaccessoryshop.model.entity.ProductEntity;
import com.example.phoneaccessoryshop.repository.ModelRepository;
import com.example.phoneaccessoryshop.repository.ProductRepository;
import com.example.phoneaccessoryshop.service.ProductService;
import org.modelmapper.ModelMapper;
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
    public void addProduct(AddProductDTO addProductDTO) {

        ProductEntity product = modelMapper.map(addProductDTO, ProductEntity.class);
        product.setModel(modelRepository.findByName(addProductDTO.getModelName()));
        product.setProductNumber(UUID.randomUUID());
        productRepository.save(product);

    }

    @Override
    public List<ProductViewDTO> getAllProducts() {
        return productRepository.getAllProducts().stream().map(ProductServiceImpl::map).toList();
    }

    private static ProductViewDTO map(ProductEntity product){
        return new ProductViewDTO(product.getModel().getBrand().getName(),product.getModel().getName(), product.getName(), product.getProductNumber(),product.getQuantity());
    }
}
