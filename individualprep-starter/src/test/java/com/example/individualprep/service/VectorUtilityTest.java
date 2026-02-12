package com.example.individualprep.service;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

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

    // Person D
    @Test
    void testDotProductValid() {
        double[] v1 = {1.0, 2.0, 3.0};
        double[] v2 = {4.0, 5.0, 6.0};
        assertEquals(32.0, vectorUtility.dotProduct(v1, v2), 0.0001);
    }

    @Test
    void testDotProductZeroVector() {
        double[] v1 = {1.0, 2.0};
        double[] v2 = {0.0, 0.0};
        assertEquals(0.0, vectorUtility.dotProduct(v1, v2), 0.0001);
    }

    @Test
    void testDotProductDifferentLengthThrowsException() {
        double[] v1 = {1.0, 2.0};
        double[] v2 = {1.0, 2.0, 3.0};
        
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            vectorUtility.dotProduct(v1, v2);
        });
        
        assertEquals("Both vectors must have the same length!", exception.getMessage());
    }

    @Test
    void testDotProductNullVectorThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> {
            vectorUtility.dotProduct(null, new double[]{1.0});
        });
    }
}
