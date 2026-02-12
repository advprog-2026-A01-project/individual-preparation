package com.example.individualprep.dto;

public record ArithmeticRequest(
    double operand1,
    double operand2,
    Integer exponent // Optional, only used for exponent operation
) {
}

