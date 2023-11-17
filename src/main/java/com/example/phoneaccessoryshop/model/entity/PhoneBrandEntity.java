package com.example.phoneaccessoryshop.model.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "phone_brands")
public class PhoneBrandEntity extends BaseEntity {
    @Column(nullable = false)
    private String name;

    @OneToMany(
            fetch = FetchType.LAZY,
            mappedBy = "brand"
    )
    private List<PhoneModelEntity> models;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<PhoneModelEntity> getModels() {
        return models;
    }

    public void setModels(List<PhoneModelEntity> models) {
        this.models = models;
    }
}
