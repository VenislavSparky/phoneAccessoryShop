package com.example.phoneaccessoryshop.service.impl;

import com.example.phoneaccessoryshop.model.dto.AddModelDTO;
import com.example.phoneaccessoryshop.model.dto.BrandDTO;
import com.example.phoneaccessoryshop.model.dto.ModelViewDTO;
import com.example.phoneaccessoryshop.model.entity.PhoneBrandEntity;
import com.example.phoneaccessoryshop.model.entity.PhoneModelEntity;
import com.example.phoneaccessoryshop.model.entity.ProductEntity;
import com.example.phoneaccessoryshop.repository.BrandRepository;
import com.example.phoneaccessoryshop.repository.ModelRepository;
import com.example.phoneaccessoryshop.service.ModelService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ModelServiceImpl implements ModelService {
    private final ModelRepository modelRepository;
    private final BrandRepository brandRepository;
    private final ModelMapper modelMapper;
    private List<PhoneModelEntity> allModels;

    public ModelServiceImpl(ModelRepository modelRepository, BrandRepository brandRepository, ModelMapper modelMapper) {
        this.modelRepository = modelRepository;
        this.brandRepository = brandRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public void addModel(AddModelDTO addModelDTO) {
        PhoneModelEntity model = new PhoneModelEntity();

        PhoneBrandEntity brand = brandRepository.findByName(addModelDTO.getBrandName());

        model.setName(addModelDTO.getName());
        model.setBrand(brand);

        modelRepository.save(model);
    }

    @Override
    public List<AddModelDTO> getAllModels() {
        allModels = modelRepository.getAllModels();
        return allModels.stream().map(model -> modelMapper.map(model, AddModelDTO.class)).toList();
    }

    @Override
    public List<ModelViewDTO> getAllModelsView() {
        return modelRepository.getAllModels().stream().map(ModelServiceImpl::map).toList();
    }

    @Override
    public void deleteModel(Long id) {
        modelRepository.deleteById(id);
    }

    @Override
    public Long findModelIdByName(String searchBy) {
    return modelRepository.findByName(searchBy).getId();
    }

    public static ModelViewDTO map(PhoneModelEntity model) {

        int totalQuantity = model.getProducts().stream().mapToInt(ProductEntity::getQuantity).sum();

        return new ModelViewDTO(model.getId(), model.getName(), model.getProducts().size(), totalQuantity);
    }
}
