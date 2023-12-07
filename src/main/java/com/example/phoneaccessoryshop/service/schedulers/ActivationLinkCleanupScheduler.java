package com.example.phoneaccessoryshop.service.schedulers;

import com.example.phoneaccessoryshop.service.UserActivationService;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ActivationLinkCleanupScheduler {

    private final UserActivationService userActivationService;

    public ActivationLinkCleanupScheduler(UserActivationService userActivationService) {
        this.userActivationService = userActivationService;
    }

    @Scheduled(fixedRate = 600000)
    public void cleanUp(){
        System.out.println("Cleaning Activation Codes....");
        userActivationService.cleanUpObsoleteActivationLinks();
    }
}
