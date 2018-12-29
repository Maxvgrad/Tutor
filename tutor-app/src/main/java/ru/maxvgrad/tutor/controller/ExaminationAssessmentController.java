//package ru.maxvgrad.tutor.controller;
//
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.http.MediaType;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.ResponseBody;
//import ru.maxvgrad.tutor.entity.ExaminationAssessment;
//import ru.maxvgrad.tutor.service.ExaminationAssessmentService;
//
//import java.util.List;
//
//@Slf4j
//public abstract class ExaminationAssessmentController<T> {
//
//    private final ExaminationAssessmentService<T> examinationAssessmentService;
//
//    public ExaminationAssessmentController(ExaminationAssessmentService<T> examinationAssessmentService) {
//        this.examinationAssessmentService = examinationAssessmentService;
//    }
//
//    @GetMapping
//    public @ResponseBody List<ExaminationAssessment<T>> listAll() {
//        log.debug("#listAll: ExaminationAssessment");
//        return examinationAssessmentService.listAll();
//    }
//
//    @PutMapping(consumes = {MediaType.APPLICATION_JSON_VALUE})
//    public @ResponseBody ExaminationAssessment<T> save(@PathVariable T submittingForm) {
//        log.debug("#save: submittingForm({})", submittingForm.toString());
//        return examinationAssessmentService.save(submittingForm);
//    }
//
//    @GetMapping("/{id}")
//    public @ResponseBody ExaminationAssessment<T> get(@PathVariable Long id) {
//        log.debug("#get: examinationAssessment(id: {})", id);
//        return examinationAssessmentService.get(id);
//    }
//
//    @PostMapping(value = "/{id}", consumes = { MediaType.APPLICATION_JSON_VALUE })
//    public @ResponseBody ExaminationAssessment<T> evaluate(@RequestBody T submittingForm) {
//        log.debug("#evaluate: submittingForm({})", submittingForm.toString());
//        return examinationAssessmentService.evaluate(submittingForm);
//    }
//
//    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
//    public @ResponseBody ExaminationAssessment<T> delete(@PathVariable Long id) {
//        log.debug("#delete: submittingForm(id: {})", id);
//        return examinationAssessmentService.remove(id);
//    }
//}