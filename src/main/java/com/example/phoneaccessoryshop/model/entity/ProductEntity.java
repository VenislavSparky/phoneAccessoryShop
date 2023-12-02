package com.example.phoneaccessoryshop.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.*;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.validator.constraints.Length;

import java.math.BigDecimal;
import java.sql.Types;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "products")
public class ProductEntity extends BaseEntity {

    @NotNull
    private String name;
    @NotNull
    @JdbcTypeCode(Types.VARCHAR)
    private UUID uuid;
    @ManyToOne
    private PhoneModelEntity model;
    @NotEmpty
    @Length(min = 10, max = 200)
    private String description;
    @NotNull
    private String color;
    @Positive
    private BigDecimal price;
    @Positive
    private BigDecimal discount;
    @FutureOrPresent
    private LocalDateTime discountStartDate;
    @Future
    private LocalDateTime discountEndDate;
    @Positive
    private Integer quantity;
    @NotEmpty
    private String imageUrl;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID productNumber) {
        this.uuid = productNumber;
    }

    public PhoneModelEntity getModel() {
        return model;
    }

    public void setModel(PhoneModelEntity model) {
        this.model = model;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getDiscount() {
        return discount;
    }

    public void setDiscount(BigDecimal discount) {
        this.discount = discount;
    }

    public LocalDateTime getDiscountStartDate() {
        return discountStartDate;
    }

    public void setDiscountStartDate(LocalDateTime discountStartDate) {
        this.discountStartDate = discountStartDate;
    }

    public LocalDateTime getDiscountEndDate() {
        return discountEndDate;
    }

    public void setDiscountEndDate(LocalDateTime discountEndDate) {
        this.discountEndDate = discountEndDate;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
