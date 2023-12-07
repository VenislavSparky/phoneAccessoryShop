package com.example.phoneaccessoryshop.service;

import com.example.phoneaccessoryshop.model.dto.ModelDTO;
import com.example.phoneaccessoryshop.model.dto.view.ModelViewDTO;

import java.util.List;

public interface ModelService {
    void addModel(ModelDTO modelDTO);

    List<ModelDTO> getAllModels();

    List<ModelViewDTO> getAllModelViews();

    void deleteModel(Long id);

    Long findModelIdByName(String searchBy);
}
