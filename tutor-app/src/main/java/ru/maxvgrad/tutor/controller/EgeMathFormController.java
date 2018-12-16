package ru.maxvgrad.tutor.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.maxvgrad.tutor.TutorApplication;
import ru.maxvgrad.tutor.entity.JsonEgeMathProfForm;

@RestController
@RequestMapping(TutorApplication.MODULE_BASE_URL)
public class EgeMathFormController {



    @PostMapping("/")
    public JsonEgeMathProfForm evaluate(@RequestParam() JsonEgeMathProfForm mathForm) {


        return null;
    }

}
