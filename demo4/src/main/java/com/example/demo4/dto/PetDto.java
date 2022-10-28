package com.example.demo4.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class PetDto {
    public final static String DATE_PATTERN = "dd.MM.yyyy";

    private String name;
    private  int age;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern= DATE_PATTERN)
    private LocalDate dayFrom;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern= DATE_PATTERN)
    private  LocalDate dayTo;
    private String period;
}
