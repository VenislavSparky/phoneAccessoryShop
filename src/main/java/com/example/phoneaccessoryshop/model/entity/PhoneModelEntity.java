package com.example.phoneaccessoryshop.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "phone_models")
public class PhoneModelEntity extends BaseEntity {

    @Column(nullable = false)
    private String name;

    @ManyToOne
    private PhoneBrandEntity brand;

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
