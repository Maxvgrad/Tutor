package ru.maxvgrad.tutor.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.maxvgrad.tutor.dto.enums.ExaminationAssesmentStatus;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import java.time.Instant;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ExaminationAssessment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Instant creationDate;

    @Column
    private Instant submitDate;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private ExaminationAssesmentStatus status;

    @Column
    private Integer mark;

    @ManyToOne
    private AppUser user;

    @ManyToOne
    private ExaminationAssessmentAnswer answer;

    @OneToOne
    private ExaminationAssessmentMistake mistake;

    @OneToOne
    private ExaminationForm examinationForm;
}
