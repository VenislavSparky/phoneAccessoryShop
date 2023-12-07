package com.example.phoneaccessoryshop.service;

import com.example.phoneaccessoryshop.model.dto.AddModelDTO;
import com.example.phoneaccessoryshop.model.dto.ModelViewDTO;
import com.example.phoneaccessoryshop.model.entity.PhoneModelEntity;

import java.util.List;

public interface ModelService {
    void addModel(AddModelDTO addModelDTO);

    List<AddModelDTO> getAllModels();

    List<ModelViewDTO> getAllModelsView();

    void deleteModel(Long id);

    Long findModelIdByName(String searchBy);
}
