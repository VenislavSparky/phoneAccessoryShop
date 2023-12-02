package com.example.phoneaccessoryshop.service;

public interface EmailService {
    void sendRegistrationEmail(String userEmail,String username, String activationCode);

}
