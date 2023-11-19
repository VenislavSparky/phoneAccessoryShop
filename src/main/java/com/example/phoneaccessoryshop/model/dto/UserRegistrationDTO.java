package com.example.phoneaccessoryshop.model.dto;


import com.example.phoneaccessoryshop.model.validation.UniqueUserEmail;
import jakarta.validation.constraints.*;
import org.springframework.boot.autoconfigure.security.servlet.PathRequest;

public class UserRegistrationDTO {
    @NotEmpty
    @Size(min = 3, max = 20, message = "Length must be between 3 and 20 characters!")
    private String firstName;
    @NotEmpty
    @Size(min = 3, max = 20, message = "Length must be between 3 and 20 characters!")
    private String lastName;
    @NotBlank(message = "Email cannot be empty!")
    @Email
    @UniqueUserEmail
    private String email;
    @NotEmpty
    @Size(min = 3, max = 20, message = "Must be between 3 and 20 characters!")
    private String password;
    @NotEmpty
    @Size(min = 3, max = 20, message = "Must be between 3 and 20 characters!")
    private String confirmPassword;
    @Positive
    @Min(value = 18, message = "User must be at least 18 years old!")
    private Integer age;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}


