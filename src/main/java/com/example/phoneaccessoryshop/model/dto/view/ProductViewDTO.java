package com.example.phoneaccessoryshop.model.dto.view;

import java.util.UUID;

public record ProductViewDTO(String brand, String model, String name, UUID productUUID, int quantity) {

}
