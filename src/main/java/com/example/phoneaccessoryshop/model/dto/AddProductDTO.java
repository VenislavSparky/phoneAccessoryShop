package com.example.phoneaccessoryshop.model.dto;

import com.example.phoneaccessoryshop.model.entity.PhoneModelEntity;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.*;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.validator.constraints.Length;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.math.BigDecimal;
import java.sql.Types;
import java.time.LocalDateTime;
import java.util.UUID;

public class AddProductDTO {

    @NotNull
    private String name;
    @NotNull
    @JdbcTypeCode(Types.VARCHAR)
    private UUID productNumber;
    private String modelName;
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

    private String imageUrl;

    public AddProductDTO() {
    }

    public AddProductDTO(String name, UUID productNumber, String modelName, String description, String color, BigDecimal price, BigDecimal discount, LocalDateTime discountStartDate, LocalDateTime discountEndDate, Integer quantity, String imageUrl) {
        this.name = name;
        this.productNumber = productNumber;
        this.modelName = modelName;
        this.description = description;
        this.color = color;
        this.price = price;
        this.discount = discount;
        this.discountStartDate = discountStartDate;
        this.discountEndDate = discountEndDate;
        this.quantity = quantity;
        this.imageUrl = imageUrl;

    }

    public static Object empty() {
        return new AddProductDTO(null, null, null, null, null, null, null, null, null, null, null);
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

    public UUID getProductNumber() {
        return productNumber;
    }

    public void setProductNumber(UUID productNumber) {
        this.productNumber = productNumber;
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


}
