package ru.maxvgrad.tutor.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.maxvgrad.tutor.TutorApplication;
import ru.maxvgrad.tutor.dto.EgeMathProfFormDto;
import ru.maxvgrad.tutor.service.EgeMathProfAnswerService;

@RestController
@RequestMapping(TutorApplication.MODULE_BASE_URL + "/examination/assessment/ege/math/prof")
public class EgeMathPorfAnswerController extends AnswerController<EgeMathProfFormDto> {

    public EgeMathPorfAnswerController(EgeMathProfAnswerService answerService) {
        super(answerService);
    }
}
