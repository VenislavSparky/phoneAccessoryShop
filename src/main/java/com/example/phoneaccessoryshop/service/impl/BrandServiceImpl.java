package com.example.phoneaccessoryshop.service.impl;

import com.example.phoneaccessoryshop.model.dto.BrandDTO;
import com.example.phoneaccessoryshop.model.entity.PhoneBrandEntity;
import com.example.phoneaccessoryshop.repository.BrandRepository;
import com.example.phoneaccessoryshop.service.BrandService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BrandServiceImpl implements BrandService {
    private final BrandRepository brandRepository;
    private final ModelMapper modelMapper;
    private List<PhoneBrandEntity> allBrands;

    public BrandServiceImpl(BrandRepository brandRepository, ModelMapper modelMapper) {
        this.brandRepository = brandRepository;
        this.modelMapper = modelMapper;
    }

    public void addBrand(PhoneBrandEntity brand) {
        brandRepository.save(brand);
    }

    @Override
    public boolean addBrand(BrandDTO addBrandDTO) {
        PhoneBrandEntity brand = modelMapper.map(addBrandDTO, PhoneBrandEntity.class);

        brandRepository.save(brand);

        return false;
    }

    @Override
    public List<BrandDTO> getAllBrands() {
        allBrands = brandRepository.getAllBrands();
        return allBrands.stream().map(brand -> modelMapper.map(brand, BrandDTO.class)).toList();
    }
}
