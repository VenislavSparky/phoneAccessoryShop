package com.example.phoneaccessoryshop.service.impl;

import com.example.phoneaccessoryshop.model.dto.ModelDTO;
import com.example.phoneaccessoryshop.model.dto.view.ModelViewDTO;
import com.example.phoneaccessoryshop.model.entity.BrandEntity;
import com.example.phoneaccessoryshop.model.entity.ModelEntity;
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

    public ModelServiceImpl(ModelRepository modelRepository, BrandRepository brandRepository, ModelMapper modelMapper) {
        this.modelRepository = modelRepository;
        this.brandRepository = brandRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public void addModel(ModelDTO modelDTO) {
        ModelEntity model = new ModelEntity();

        BrandEntity brand = brandRepository.findByName(modelDTO.getBrandName());

        model.setName(modelDTO.getName());
        model.setBrand(brand);

        modelRepository.save(model);
    }

    @Override
    public List<ModelDTO> getAllModels() {
        List<ModelEntity> allModels = modelRepository.getAllModels();
        return allModels.stream().map(model -> modelMapper.map(model, ModelDTO.class)).toList();
    }

    @Override
    public List<ModelViewDTO> getAllModelViews() {
        return modelRepository.getAllModels().stream().map(ModelServiceImpl::map).toList();
    }

    @Override
    public void deleteModel(Long id) {
        modelRepository.deleteById(id);
    }

    @Override
    public Long findModelIdByName(String name) {
    return modelRepository.findByName(name).getId();
    }

    public static ModelViewDTO map(ModelEntity model) {

        int totalQuantity = model.getProducts().stream().mapToInt(ProductEntity::getQuantity).sum();

        return new ModelViewDTO(model.getId(), model.getName(), model.getProducts().size(), totalQuantity);
    }
}
