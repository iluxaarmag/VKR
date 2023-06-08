package com.example.demo.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class GraphicDataRequestDto {
    LocalDate date;
    double temperature;
}
