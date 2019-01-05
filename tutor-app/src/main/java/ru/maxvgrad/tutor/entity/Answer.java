package ru.maxvgrad.tutor.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Table(name = "answer")
@Entity
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Answer extends BaseJsonEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private Integer total;

    @ManyToOne(targetEntity = ExaminationForm.class)
    private ExaminationForm examinationForm;

    @Type(type = "jsonb")
    @Column(columnDefinition = "jsonb")
    private String submitForm;
}
