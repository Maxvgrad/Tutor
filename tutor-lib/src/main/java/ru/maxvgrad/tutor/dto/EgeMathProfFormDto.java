package ru.maxvgrad.tutor.dto;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
public class EgeMathProfFormDto extends SubmissionForm implements Serializable {

    @Builder
    public EgeMathProfFormDto(Long id, Long examinationFormId, Double b1, Double b2, Double b3, Double b4,
                              Double b5, Double b6, Double b7, Double b8, Double b9, Double b10, Double b11,
                              Double b12, Double c1, Double c2, Double c3, Double c4, Double c5, Double c6,
                              Double c7) {
        super(id, examinationFormId);
        this.b1 = b1;
        this.b2 = b2;
        this.b3 = b3;
        this.b4 = b4;
        this.b5 = b5;
        this.b6 = b6;
        this.b7 = b7;
        this.b8 = b8;
        this.b9 = b9;
        this.b10 = b10;
        this.b11 = b11;
        this.b12 = b12;
        this.c1 = c1;
        this.c2 = c2;
        this.c3 = c3;
        this.c4 = c4;
        this.c5 = c5;
        this.c6 = c6;
        this.c7 = c7;
    }

    private Double b1;

    private Double b2;

    private Double b3;

    private Double b4;

    private Double b5;

    private Double b6;

    private Double b7;

    private Double b8;

    private Double b9;

    private Double b10;

    private Double b11;

    private Double b12;

    private Double c1;

    private Double c2;

    private Double c3;

    private Double c4;

    private Double c5;

    private Double c6;

    private Double c7;
}
