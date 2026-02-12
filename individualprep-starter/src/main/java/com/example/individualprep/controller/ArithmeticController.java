package com.example.individualprep.controller;

import com.example.individualprep.dto.ArithmeticRequest;
import com.example.individualprep.dto.ArithmeticResponse;
import com.example.individualprep.service.ArithmeticUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/arithmetic")
public class ArithmeticController {

    private final ArithmeticUtility arithmeticUtility;

    @Autowired
    public ArithmeticController(ArithmeticUtility arithmeticUtility) {
        this.arithmeticUtility = arithmeticUtility;
    }

    @PostMapping("/add")
    public ResponseEntity<ArithmeticResponse> add(@RequestBody ArithmeticRequest request) {
        double result = arithmeticUtility.add(request.operand1(), request.operand2());
        return ResponseEntity.ok(new ArithmeticResponse(result));
    }

    @PostMapping("/subtract")
    public ResponseEntity<ArithmeticResponse> subtract(@RequestBody ArithmeticRequest request) {
        double result = arithmeticUtility.subtract(request.operand1(), request.operand2());
        return ResponseEntity.ok(new ArithmeticResponse(result));
    }

    @PostMapping("/multiply")
    public ResponseEntity<ArithmeticResponse> multiply(@RequestBody ArithmeticRequest request) {
        double result = arithmeticUtility.multiply(request.operand1(), request.operand2());
        return ResponseEntity.ok(new ArithmeticResponse(result));
    }

    @PostMapping("/divide")
    public ResponseEntity<ArithmeticResponse> divide(@RequestBody ArithmeticRequest request) {
        double result = arithmeticUtility.divide(request.operand1(), request.operand2());
        return ResponseEntity.ok(new ArithmeticResponse(result));
    }

    @PostMapping("/exponent")
    public ResponseEntity<ArithmeticResponse> exponent(@RequestBody ArithmeticRequest request) {
        if (request.exponent() == null) {
            return ResponseEntity.badRequest().build();
        }
        double result = arithmeticUtility.exponent(request.operand1(), request.exponent());
        return ResponseEntity.ok(new ArithmeticResponse(result));
    }
}

