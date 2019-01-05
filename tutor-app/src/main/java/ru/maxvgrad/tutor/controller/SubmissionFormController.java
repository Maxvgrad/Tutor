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
import ru.maxvgrad.tutor.dto.SubmissionFormDto;
import ru.maxvgrad.tutor.service.SubmissionFormService;

import java.util.List;
import java.util.Optional;

@Slf4j
public abstract class SubmissionFormController<T> {

    private final SubmissionFormService<T> answerService;

    public SubmissionFormController(SubmissionFormService<T> answerService) {
        this.answerService = answerService;
    }

    @GetMapping
    public @ResponseBody List<SubmissionFormDto<T>> listAll() {
        log.debug("#listAll:");
        return answerService.listAll();
    }

    @PutMapping(consumes = {MediaType.APPLICATION_JSON_VALUE})
    public @ResponseBody SubmissionFormDto<T> save(@PathVariable SubmissionFormDto<T> submittingForm) {
        log.debug("#save: submittingForm({})", submittingForm.toString());
        return answerService.save(submittingForm);
    }

    @GetMapping("/{id}")
    public @ResponseBody Optional<SubmissionFormDto<T>> get(@PathVariable Long id) {
        log.debug("#get: id: {}", id);
        return answerService.get(id);
    }

    @PostMapping(value = "/{id}", consumes = { MediaType.APPLICATION_JSON_VALUE })
    public @ResponseBody SubmissionFormDto<T> evaluate(@RequestBody SubmissionFormDto<T> submittingForm) {
        log.debug("#evaluate: submittingForm({})", submittingForm.toString());
        return answerService.evaluate(submittingForm);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public @ResponseBody ResponseEntity delete(@PathVariable Long id) {
        log.debug("#delete: id: {}", id);
        answerService.remove(id);
        return ResponseEntity.ok().build();
    }
}