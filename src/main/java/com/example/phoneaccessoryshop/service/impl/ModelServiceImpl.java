package com.example.phoneaccessoryshop.service.impl;

import com.example.phoneaccessoryshop.model.dto.AddModelDTO;
import com.example.phoneaccessoryshop.model.entity.PhoneBrandEntity;
import com.example.phoneaccessoryshop.model.entity.PhoneModelEntity;
import com.example.phoneaccessoryshop.repository.BrandRepository;
import com.example.phoneaccessoryshop.repository.ModelRepository;
import com.example.phoneaccessoryshop.service.ModelService;
import org.springframework.stereotype.Service;

@Service
public class ModelServiceImpl implements ModelService {
    private final ModelRepository modelRepository;
    private final BrandRepository brandRepository;

    public ModelServiceImpl(ModelRepository modelRepository, BrandRepository brandRepository) {
        this.modelRepository = modelRepository;
        this.brandRepository = brandRepository;
    }

    @Override
    public void addModel(AddModelDTO addModelDTO) {
        PhoneModelEntity model = new PhoneModelEntity();

        PhoneBrandEntity brand = brandRepository.findByName(addModelDTO.getBrandName());

        model.setName(addModelDTO.getName());
        model.setBrand(brand);

        modelRepository.save(model);
    }
}
