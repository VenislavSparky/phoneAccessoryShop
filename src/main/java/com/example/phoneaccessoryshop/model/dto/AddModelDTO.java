package com.example.phoneaccessoryshop.model.dto;

import jakarta.validation.constraints.NotEmpty;

public class AddModelDTO {

    @NotEmpty
    private String brandName;

    @NotEmpty
    private String name;

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

    public AddModelDTO() {
    }

    public AddModelDTO(String brandName, String name) {
        this.brandName = brandName;
        this.name = name;
    }

    public static Object empty() {
        return new AddModelDTO(null,null);
    }
}
