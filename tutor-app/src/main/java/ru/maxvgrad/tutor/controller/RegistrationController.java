package ru.maxvgrad.tutor.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;
import ru.maxvgrad.tutor.dto.AppUserDto;
import ru.maxvgrad.tutor.service.UserService;

import javax.validation.Valid;

@Slf4j
@Controller
@RequiredArgsConstructor
public class RegistrationController {

    private final UserService userService;

    @GetMapping(value = "/user/registration")
    public String showRegistrationForm(WebRequest request, Model model) {
        AppUserDto userDto = AppUserDto.builder().build();
        model.addAttribute("user", userDto);
        return "registration";
    }

    @PostMapping(value = "/user/registration")
    public ModelAndView registerUserAccount(@ModelAttribute("user") @Valid AppUserDto accountDto,
                                            BindingResult result, WebRequest request, Errors errors) {
        log.debug("#registerUserAccount: Account(email:{})", accountDto.getEmail());

        if (!result.hasErrors()) {
            userService.registerNewUserAccount(accountDto, result);
        }

        if (result.hasErrors()) {
            return new ModelAndView("registration", "user", accountDto);
        } else {
            return new ModelAndView("successRegister", "user", accountDto);
        }
    }
}
