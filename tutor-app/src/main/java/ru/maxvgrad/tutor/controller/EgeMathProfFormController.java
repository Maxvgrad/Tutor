package ru.maxvgrad.tutor.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.maxvgrad.tutor.TutorApplication;
import ru.maxvgrad.tutor.form.EgeMathProfForm;
import ru.maxvgrad.tutor.service.EgeMathProfFormService;

@RestController
@RequestMapping(TutorApplication.MODULE_BASE_URL + "/examination/assessment/ege/math/prof")
public class EgeMathProfFormController extends SubmissionFormController<EgeMathProfForm> {

    public EgeMathProfFormController(EgeMathProfFormService answerService) {
        super(answerService);
    }
}
