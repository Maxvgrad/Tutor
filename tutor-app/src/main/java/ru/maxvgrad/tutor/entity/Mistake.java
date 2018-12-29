package ru.maxvgrad.tutor.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;
import ru.maxvgrad.tutor.dto.MistakeFormDto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Mistake<T> extends BaseJsonEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private Integer total;

    @OneToOne(targetEntity = Answer.class)
    private Answer<T> answer;

    @Type(type = "jsonb")
    @Column
    private MistakeFormDto content;
}
