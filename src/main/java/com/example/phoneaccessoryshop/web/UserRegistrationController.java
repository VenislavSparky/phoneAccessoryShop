package com.example.phoneaccessoryshop.web;

import com.example.phoneaccessoryshop.model.dto.UserRegistrationDTO;
import com.example.phoneaccessoryshop.service.UserActivationService;
import com.example.phoneaccessoryshop.service.UserService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/user")
public class UserRegistrationController {

    private final UserService userService;
    private final UserActivationService activationService;

    public UserRegistrationController(UserService userService, UserActivationService activationService) {
        this.userService = userService;
        this.activationService = activationService;
    }

    @GetMapping("/register")
    public ModelAndView register(@ModelAttribute("userRegistrationDTO") UserRegistrationDTO userRegistrationDTO) {

        return new ModelAndView("register");
    }

    @PostMapping("/register")
    public ModelAndView register(@ModelAttribute("userRegistrationDTO") @Valid UserRegistrationDTO userRegistrationDTO, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return new ModelAndView("register");
        }

        boolean hasSuccessfulRegistration = userService.registerUser(userRegistrationDTO);

        if (!hasSuccessfulRegistration) {
            ModelAndView modelAndView = new ModelAndView("register");
            modelAndView.addObject("hasRegistrationError", true);
            return modelAndView;
        }

        return new ModelAndView("redirect:/user/login");
    }

    @GetMapping("/activate/")
    public String activateUser(@RequestParam(name = "activation_code") String activationCode) {
        activationService.activateUser(activationCode);
        return "redirect:/shop";
    }
}
