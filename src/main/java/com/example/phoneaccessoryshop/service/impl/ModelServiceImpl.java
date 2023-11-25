package com.example.phoneaccessoryshop.service.impl;
import com.example.phoneaccessoryshop.model.dto.AddModelDTO;
import com.example.phoneaccessoryshop.model.entity.PhoneModelEntity;
import com.example.phoneaccessoryshop.repository.ModelRepository;
import com.example.phoneaccessoryshop.service.ModelService;
import org.springframework.stereotype.Service;

@Service
public class ModelServiceImpl implements ModelService {
    private final ModelRepository modelRepository;

    public ModelServiceImpl(ModelRepository modelRepository) {
        this.modelRepository = modelRepository;
    }

    @Override
    public void addModel(AddModelDTO addModelDTO) {

    }
}
