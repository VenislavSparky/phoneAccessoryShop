package com.example.phoneaccessoryshop.model.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "phone_models")
public class PhoneModelEntity extends BaseEntity {

    @Column(nullable = false, unique = true)
    private String name;

    @ManyToOne
    private PhoneBrandEntity brand;

    @OneToMany(fetch = FetchType.EAGER,
            mappedBy = "model")
    private List<ProductEntity> products;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public PhoneBrandEntity getBrand() {
        return brand;
    }

    public void setBrand(PhoneBrandEntity brand) {
        this.brand = brand;
    }
}
