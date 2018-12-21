package ru.maxvgrad.tutor.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.maxvgrad.tutor.TutorApplication;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping(TutorApplication.MODULE_BASE_URL + "/examination/form")
public class ExaminationFormController {
}
