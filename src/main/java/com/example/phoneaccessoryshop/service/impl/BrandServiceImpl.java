package com.example.phoneaccessoryshop.service.impl;

import com.example.phoneaccessoryshop.model.dto.BrandDTO;
import com.example.phoneaccessoryshop.model.dto.BrandViewDTO;
import com.example.phoneaccessoryshop.model.dto.ProductViewDTO;
import com.example.phoneaccessoryshop.model.entity.PhoneBrandEntity;
import com.example.phoneaccessoryshop.model.entity.ProductEntity;
import com.example.phoneaccessoryshop.repository.BrandRepository;
import com.example.phoneaccessoryshop.service.BrandService;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BrandServiceImpl implements BrandService {
    private final BrandRepository brandRepository;
    private final ModelMapper modelMapper;

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
        brand.setModels(new ArrayList<>());
        brandRepository.save(brand);

        return false;
    }

    @Override
    public List<BrandDTO> getAllBrands() {
        List<PhoneBrandEntity> allBrands = brandRepository.getAllBrands();
        return allBrands.stream().map(brand -> modelMapper.map(brand, BrandDTO.class)).toList();
    }

    @Override
    public List<BrandViewDTO> getAllBrandsView() {
        return brandRepository.getAllBrands().stream().map(BrandServiceImpl::map).toList();

    }

    @Override
    @Transactional
    public void deleteBrand(Long id) {
        brandRepository.deleteById(id);
    }

    private static BrandViewDTO map(PhoneBrandEntity brand) {
        int count = brand.getModels().stream().mapToInt(m -> m.getProducts().size()).sum();

        return new BrandViewDTO(brand.getName(), brand.getModels().size(), count, brand.getId());
    }
}
