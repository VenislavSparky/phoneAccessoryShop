package com.example.phoneaccessoryshop.service.impl;

import com.example.phoneaccessoryshop.model.entity.UserActivationCodeEntity;
import com.example.phoneaccessoryshop.model.events.UserRegisteredEvent;
import com.example.phoneaccessoryshop.repository.UserActivationCodeRepository;
import com.example.phoneaccessoryshop.repository.UserRepository;
import com.example.phoneaccessoryshop.service.EmailService;
import com.example.phoneaccessoryshop.service.UserActivationService;
import com.example.phoneaccessoryshop.service.exception.ObjectNotFoundException;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.Random;

@Service
public class UserActivationServiceImpl implements UserActivationService {

    private static final String ACTIVATION_CODE_SYMBOLS = "qwertyuiopasdfghjklzxcvbnm1234567890QWERTYUIOPASDFGHJKLZXCVBNM";
    private static final int ACTIVATION_CODE_LENGTH = 10;
    private final EmailService emailService;
    private final UserRepository userRepository;
    private final UserActivationCodeRepository userActivationCodeRepository;

    public UserActivationServiceImpl(EmailService emailService, UserRepository userRepository, UserActivationCodeRepository userActivationCodeRepository
    ) {
        this.emailService = emailService;
        this.userRepository = userRepository;
        this.userActivationCodeRepository = userActivationCodeRepository;
    }

    @EventListener(UserRegisteredEvent.class)
    @Override
    public void userRegistered(UserRegisteredEvent event) {
        createActivationCode(event.getEmail());
        emailService.sendRegistrationEmail(event.getEmail(), event.getUsername());
    }

    @Override
    public void cleanUpObsoleteActivationLinks() {

    }

    @Override
    public String createActivationCode(String userEmail) {

        UserActivationCodeEntity userActivationCodeEntity = new UserActivationCodeEntity();

        userActivationCodeEntity.setActivationCode(generateActivationCode());
        userActivationCodeEntity.setCreated(Instant.now());
        userActivationCodeEntity.setUser(userRepository.findByEmail(userEmail).orElseThrow(() -> new ObjectNotFoundException("User not found!")));
        userActivationCodeRepository.save(userActivationCodeEntity);

        return userActivationCodeEntity.getActivationCode();
    }

    private String generateActivationCode() {
        StringBuilder activationCode = new StringBuilder();
        Random random = new SecureRandom();

        for (int i = 0; i < ACTIVATION_CODE_LENGTH; i++) {
            int randIndex = random.nextInt(ACTIVATION_CODE_SYMBOLS.length());
            activationCode.append(ACTIVATION_CODE_SYMBOLS.charAt(randIndex));
        }
        return activationCode.toString();
    }


}
