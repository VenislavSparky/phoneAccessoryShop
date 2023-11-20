package com.example.phoneaccessoryshop.service.impl;
import com.example.phoneaccessoryshop.model.entity.PhoneBrandEntity;
import com.example.phoneaccessoryshop.repository.BrandRepository;
import com.example.phoneaccessoryshop.service.BrandService;
import org.springframework.stereotype.Service;

@Service
public class BrandServiceImpl implements BrandService {
    private final BrandRepository brandRepository;

    public BrandServiceImpl(BrandRepository brandRepository) {
        this.brandRepository = brandRepository;
    }

    public void addBrand(PhoneBrandEntity brand) {
        brandRepository.save(brand);
    }

}
