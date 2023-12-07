package com.example.phoneaccessoryshop.model.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "phone_models")
public class ModelEntity extends BaseEntity {

    @Column(nullable = false, unique = true)
    private String name;

    @ManyToOne
    private BrandEntity brand;

    @OneToMany(fetch = FetchType.EAGER,
            mappedBy = "model",
            cascade = CascadeType.REMOVE)
    private List<ProductEntity> products;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BrandEntity getBrand() {
        return brand;
    }

    public void setBrand(BrandEntity brand) {
        this.brand = brand;
    }

    public List<ProductEntity> getProducts() {
        return products;
    }
}
