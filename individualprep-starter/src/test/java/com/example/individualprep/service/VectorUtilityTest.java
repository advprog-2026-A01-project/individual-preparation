package com.example.individualprep.service;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class VectorUtilityTest {

    private final VectorUtility vectorUtility = new VectorUtility();

    // <----- Person C ----->
    @Test
    void multiply_scalesVector() {
        assertArrayEquals(
                new double[] {2.0, 4.0, 6.0},
                vectorUtility.multiply(new double[] {1.0, 2.0, 3.0}, 2),
                1e-12
        );
    }

    @Test
    void multiply_withNegativeScalar() {
        assertArrayEquals(
                new double[] {-2.0, 4.0, -6.0},
                vectorUtility.multiply(new double[] {1.0, -2.0, 3.0}, -2),
                1e-12
        );
    }

    @Test
    void multiply_withZeroScalar() {
        assertArrayEquals(
                new double[] {0.0, 0.0, 0.0},
                vectorUtility.multiply(new double[] {1.0, -2.0, 3.0}, 0),
                1e-12
        );
    }

    @Test
    void multiply_emptyVector() {
        assertArrayEquals(
                new double[] { },
                vectorUtility.multiply(new double[] { }, 5),
                1e-12
        );
    }
}
