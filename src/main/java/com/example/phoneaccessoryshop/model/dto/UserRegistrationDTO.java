package com.example.phoneaccessoryshop.model.dto;


import com.example.phoneaccessoryshop.model.validation.UniqueUserEmail;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public record UserRegistrationDTO(@NotEmpty String firstName, @NotEmpty String lastName, @NotNull @Email @UniqueUserEmail String email, @NotEmpty String password, @NotEmpty String confirmPassword) {

}
