package com.example.phoneaccessoryshop.service;

import com.example.phoneaccessoryshop.model.dto.AddModelDTO;

import java.util.List;

public interface ModelService {
    void addModel(AddModelDTO addModelDTO);

    List<AddModelDTO> getAllModels();
}
