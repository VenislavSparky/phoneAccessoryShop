package com.example.phoneaccessoryshop.service;

import com.example.phoneaccessoryshop.model.dto.BrandsDTO;
import com.example.phoneaccessoryshop.model.entity.PhoneBrandEntity;

import java.util.List;


public interface BrandService {
    boolean addBrand(BrandsDTO addBrandDTO);

    List<PhoneBrandEntity> getAllBrands();
}
