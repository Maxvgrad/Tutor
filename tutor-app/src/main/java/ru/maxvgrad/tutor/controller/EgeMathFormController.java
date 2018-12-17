package ru.maxvgrad.tutor.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.maxvgrad.tutor.TutorApplication;
import ru.maxvgrad.tutor.entity.Form;
import ru.maxvgrad.tutor.entity.JsonEgeMathProfForm;
import ru.maxvgrad.tutor.repository.FormRepository;

@RestController
@RequestMapping(TutorApplication.MODULE_BASE_URL)
public class EgeMathFormController {

    @Autowired
    private FormRepository formRepository;

    @PostMapping("/")
    public JsonEgeMathProfForm evaluate(@RequestBody JsonEgeMathProfForm mathForm) {

        JsonEgeMathProfForm body = JsonEgeMathProfForm.builder().b1(42D).b3(54D).build();
        Form form = Form.builder().body(body).build();
        formRepository.save(form);
        return null;
    }

}
