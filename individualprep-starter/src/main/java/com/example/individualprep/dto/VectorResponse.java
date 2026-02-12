package com.example.individualprep.dto;

public record VectorResponse(
    double[] result,
    Double scalarResult // For operations that return a scalar (dotProduct, norm)
) {
    // Constructor for vector results
    public VectorResponse(double[] result) {
        this(result, null);
    }

    // Constructor for scalar results
    public VectorResponse(double scalarResult) {
        this(null, scalarResult);
    }
}

