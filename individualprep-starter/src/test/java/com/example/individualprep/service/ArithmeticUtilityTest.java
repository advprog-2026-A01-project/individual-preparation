package com.example.individualprep.service;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ArithmeticUtilityTest {

    private final ArithmeticUtility arithmeticUtility = new ArithmeticUtility();

    // <----- Person C ----->
    @Test
    void multiply_twoPositiveNumbers() {
        assertEquals(12.0, arithmeticUtility.multiply(4.0, 3.0), 1e-12);
    }

    @Test
    void multiply_withNegativeNumber() {
        assertEquals(-12.0, arithmeticUtility.multiply(-4.0, 3.0), 1e-12);
    }

    @Test
    void multiply_withZero() {
        assertEquals(0.0, arithmeticUtility.multiply(0.0, 999.0), 1e-12);
    }

    @Test
    void multiply_decimals() {
        assertEquals(10.0, arithmeticUtility.multiply(2.5, 4.0), 1e-12);
    }
}
