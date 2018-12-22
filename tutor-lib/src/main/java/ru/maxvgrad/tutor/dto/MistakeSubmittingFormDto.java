package ru.maxvgrad.tutor.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MistakeSubmittingFormDto {
    private List<String> mistakes = new ArrayList<>();
}
