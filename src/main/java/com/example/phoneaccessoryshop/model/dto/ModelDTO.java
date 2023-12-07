package com.example.phoneaccessoryshop.model.dto;

import jakarta.validation.constraints.NotNull;

public class ModelDTO {

    @NotNull
    private String brandName;
    @NotNull
    private String name;

    public static Object empty() {
        return new ModelDTO(null,null);
    }

    public ModelDTO(String brandName, String name) {
        this.brandName = brandName;
        this.name = name;
    }

    public ModelDTO() {
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
