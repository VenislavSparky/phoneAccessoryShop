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

    @Scheduled(cron = "*/10 * * * * *")
    public void cleanUp(){
        System.out.println("trigger");
        userActivationService.cleanUpObsoleteActivationLinks();
    }
}
