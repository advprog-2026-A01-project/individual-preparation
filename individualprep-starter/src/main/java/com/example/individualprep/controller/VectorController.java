package com.example.individualprep.controller;

import com.example.individualprep.dto.VectorRequest;
import com.example.individualprep.dto.VectorResponse;
import com.example.individualprep.service.VectorUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/vector")
public class VectorController {

    private final VectorUtility vectorUtility;

    @Autowired
    public VectorController(VectorUtility vectorUtility) {
        this.vectorUtility = vectorUtility;
    }

    @PostMapping("/add")
    public ResponseEntity<VectorResponse> add(@RequestBody VectorRequest request) {
        double[] result = vectorUtility.add(request.vector1(), request.vector2());
        return ResponseEntity.ok(new VectorResponse(result));
    }

    @PostMapping("/subtract")
    public ResponseEntity<VectorResponse> subtract(@RequestBody VectorRequest request) {
        double[] result = vectorUtility.subtract(request.vector1(), request.vector2());
        return ResponseEntity.ok(new VectorResponse(result));
    }

    @PostMapping("/multiply")
    public ResponseEntity<VectorResponse> multiply(@RequestBody VectorRequest request) {
        if (request.scalar() == null) {
            return ResponseEntity.badRequest().build();
        }
        double[] result = vectorUtility.multiply(request.vector1(), request.scalar());
        return ResponseEntity.ok(new VectorResponse(result));
    }

    @PostMapping("/dotProduct")
    public ResponseEntity<VectorResponse> dotProduct(@RequestBody VectorRequest request) {
        double result = vectorUtility.dotProduct(request.vector1(), request.vector2());
        return ResponseEntity.ok(new VectorResponse(result));
    }

    @PostMapping("/norm")
    public ResponseEntity<VectorResponse> norm(@RequestBody VectorRequest request) {
        double result = vectorUtility.norm(request.vector1());
        return ResponseEntity.ok(new VectorResponse(result));
    }
}

