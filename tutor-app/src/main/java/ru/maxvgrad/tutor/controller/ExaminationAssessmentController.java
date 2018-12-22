package ru.maxvgrad.tutor.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.maxvgrad.tutor.service.ExaminationAssessmentService;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;

@Slf4j
public abstract class ExaminationAssessmentController<T, ID extends Serializable> {

    private final ExaminationAssessmentService<T> examinationAssessmentService;

    public ExaminationAssessmentController(ExaminationAssessmentService<T> examinationAssessmentService) {
        this.examinationAssessmentService = examinationAssessmentService;
    }

    @GetMapping
    public @ResponseBody List<T> listAll() {
        log.debug("#listAll:");
        return Collections.emptyList();
    }

    @PutMapping(value = "/{id}", consumes = {MediaType.APPLICATION_JSON_VALUE})
    public @ResponseBody ResponseEntity save(@PathVariable ID id, @RequestBody T submittingForm) {
        log.debug("#save: submittingForm(id: {}, class: {})", id, submittingForm.getClass());
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public @ResponseBody T get(@PathVariable ID id) {
        log.debug("#get: submittingForm(id: {})", id);
        return null;
    }

    @PostMapping(value = "/{id}", consumes = { MediaType.APPLICATION_JSON_VALUE })
    public @ResponseBody ResponseEntity evaluate(@PathVariable ID id, @RequestBody T submittingForm) {
        log.debug("#evaluate: submittingForm(id: {}, class: {})", id, submittingForm.getClass());
        return ResponseEntity.ok().build();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public @ResponseBody ResponseEntity delete(@PathVariable ID id) {
        log.debug("#delete: submittingForm(id: {})", id);
        return ResponseEntity.ok().build();
    }
}