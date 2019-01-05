package ru.maxvgrad.tutor.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;
import ru.maxvgrad.tutor.dto.enums.ExaminationFormType;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.Instant;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ExaminationForm extends BaseJsonEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Instant creationDate;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private ExaminationFormType examType;

    @Column
    private String description;

    @Column(nullable = false)
    private Integer total;

    @Type(type = "jsonb")
    @Column(columnDefinition = "jsonb", nullable = false)
    private String questionKey;

}
