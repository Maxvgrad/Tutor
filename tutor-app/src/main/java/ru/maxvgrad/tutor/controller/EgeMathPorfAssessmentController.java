package ru.maxvgrad.tutor.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.maxvgrad.tutor.TutorApplication;
import ru.maxvgrad.tutor.entity.forms.EgeMathProfSubmittingForm;
import ru.maxvgrad.tutor.service.EgeMathProfAssessmentService;

@RestController
@RequestMapping(TutorApplication.MODULE_BASE_URL + "/examination/assessment/ege/math/prof")
public class EgeMathPorfAssessmentController extends ExaminationAssessmentController<EgeMathProfSubmittingForm, Long> {

    public EgeMathPorfAssessmentController(EgeMathProfAssessmentService examinationAssessmentService) {
        super(examinationAssessmentService);
    }
}
