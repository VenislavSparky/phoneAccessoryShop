package com.example.phoneaccessoryshop.model.dto;

import jakarta.validation.constraints.NotEmpty;
public class BrandsDTO {

    @NotEmpty
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
