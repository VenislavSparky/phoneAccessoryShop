package com.example.phoneaccessoryshop.service.impl;
import com.example.phoneaccessoryshop.model.entity.ProductEntity;
import com.example.phoneaccessoryshop.repository.ProductRepository;
import com.example.phoneaccessoryshop.service.ProductService;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public void addProduct(ProductEntity product) {
        productRepository.save(product);
    }

}
