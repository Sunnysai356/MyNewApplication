package com.example.backend.DTO;

import lombok.Data;

@Data
public class CalculationRequest {
    private int value1;
    private int value2;
    private String operation;
}
