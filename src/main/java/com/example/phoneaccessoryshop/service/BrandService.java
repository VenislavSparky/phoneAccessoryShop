package com.example.phoneaccessoryshop.service;

import com.example.phoneaccessoryshop.model.dto.BrandDTO;
import com.example.phoneaccessoryshop.model.dto.view.BrandViewDTO;

import java.util.List;


public interface BrandService {
    boolean addBrand(BrandDTO addBrandDTO);

    List<BrandDTO> getAllBrands();

    List<BrandViewDTO> getAllBrandViews();

    void deleteBrand(Long id);
}
