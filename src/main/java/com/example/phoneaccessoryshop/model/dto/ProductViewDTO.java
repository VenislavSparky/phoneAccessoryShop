package com.example.phoneaccessoryshop.model.dto;

import java.util.UUID;

public record ProductViewDTO(String brand, String model, String name, UUID productSN, int quantity) {

}
