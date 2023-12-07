package com.example.phoneaccessoryshop.model.dto;

import jakarta.validation.constraints.*;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.validator.constraints.Length;

import java.math.BigDecimal;
import java.sql.Types;
import java.time.LocalDateTime;
import java.util.UUID;

public class ProductDTO {
    private Long id;
    @NotNull
    private String name;
    @NotNull
    @JdbcTypeCode(Types.VARCHAR)
    private UUID productUUID;
    private String modelName;
    @NotEmpty
    @Length(min = 3, max = 200)
    private String description;
    @NotNull
    private String color;
    @Positive
    private BigDecimal price;
    @Positive
    private BigDecimal discountPrice;
    @FutureOrPresent
    private LocalDateTime discountStartDate;
    @Future
    private LocalDateTime discountEndDate;
    @Positive
    private Integer quantity;
    @NotNull
    private String imageUrl;

    public ProductDTO() {
    }

    public ProductDTO(String name, UUID productUUID, String modelName, String description, String color, BigDecimal price, BigDecimal discountPrice, LocalDateTime discountStartDate, LocalDateTime discountEndDate, Integer quantity, String imageUrl) {
        this.name = name;
        this.productUUID = productUUID;
        this.modelName = modelName;
        this.description = description;
        this.color = color;
        this.price = price;
        this.discountPrice = discountPrice;
        this.discountStartDate = discountStartDate;
        this.discountEndDate = discountEndDate;
        this.quantity = quantity;
        this.imageUrl = imageUrl;

    }

    public static Object empty() {
        return new ProductDTO(null, null, null, null, null, null, null, null, null, null, null);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public UUID getProductUUID() {
        return productUUID;
    }

    public void setProductUUID(UUID productUUID) {
        this.productUUID = productUUID;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
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

    public BigDecimal getDiscountPrice() {
        return discountPrice;
    }

    public void setDiscountPrice(BigDecimal discountPrice) {
        this.discountPrice = discountPrice;
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


}
