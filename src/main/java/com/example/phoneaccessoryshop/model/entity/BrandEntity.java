package com.example.phoneaccessoryshop.model.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "phone_brands")
public class BrandEntity extends BaseEntity {
    @Column(nullable = false, unique = true)
    private String name;

    @OneToMany(
            fetch = FetchType.LAZY,
            mappedBy = "brand",cascade = CascadeType.REMOVE
    )
    private List<ModelEntity> models;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<ModelEntity> getModels() {
        return models;
    }

    public void setModels(List<ModelEntity> models) {
        this.models = models;
    }
}
