package ru.maxvgrad.tutor.entity.forms;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.maxvgrad.tutor.entity.BaseJsonEntity;

import javax.persistence.Column;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EgeMathProfSubmittingForm extends BaseJsonEntity {

    @Column(name = "b1")
    private Double b1;

    @Column(name = "b2")
    private Double b2;

    @Column(name = "b3")
    private Double b3;

    @Column(name = "b4")
    private Double b4;

    @Column(name = "b5")
    private Double b5;

    @Column(name = "b6")
    private Double b6;

    @Column(name = "b7")
    private Double b7;

    @Column(name = "b8")
    private Double b8;

    @Column(name = "b9")
    private Double b9;

    @Column(name = "b10")
    private Double b10;

    @Column(name = "b11")
    private Double b11;

    @Column(name = "b12")
    private Double b12;

    @Column(name = "c1")
    private Double c1;

    @Column(name = "c2")
    private Double c2;

    @Column(name = "c3")
    private Double c3;

    @Column(name = "c4")
    private Double c4;

    @Column(name = "c5")
    private Double c5;

    @Column(name = "c6")
    private Double c6;

    @Column(name = "c7")
    private Double c7;

}
