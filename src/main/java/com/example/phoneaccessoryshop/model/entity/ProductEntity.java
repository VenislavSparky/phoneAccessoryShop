package com.example.phoneaccessoryshop.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "products")
public class ProductEntity extends BaseEntity {
    private String name;
    @ManyToOne
    private PhoneModelEntity model;
    private String description;
    private String color;
    private BigDecimal price;
    private BigDecimal discount;
    private LocalDateTime discountStartDate;
    private LocalDateTime discountEndDate;
    private Integer quantity;
    @NotEmpty
    private String imageUrl;

}
