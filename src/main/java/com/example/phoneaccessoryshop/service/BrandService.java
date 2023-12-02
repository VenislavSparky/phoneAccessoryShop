package com.example.phoneaccessoryshop.service;

import com.example.phoneaccessoryshop.model.dto.BrandDTO;
import com.example.phoneaccessoryshop.model.dto.BrandViewDTO;

import java.util.List;


public interface BrandService {
    boolean addBrand(BrandDTO addBrandDTO);

    List<BrandDTO> getAllBrands();

    List<BrandViewDTO> getAllBrandsView();

    void deleteBrand(Long id);
}
