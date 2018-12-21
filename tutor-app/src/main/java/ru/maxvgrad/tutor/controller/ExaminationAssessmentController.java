package ru.maxvgrad.tutor.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.maxvgrad.tutor.TutorApplication;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping(TutorApplication.MODULE_BASE_URL + "/examination/assessment")
public class ExaminationAssessmentController {
}
