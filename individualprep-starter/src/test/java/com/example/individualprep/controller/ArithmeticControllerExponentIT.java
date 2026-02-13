package com.example.individualprep.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
public class ArithmeticControllerExponentIT {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void exponent_returnsPower() throws Exception {
        mockMvc.perform(
                        post("/api/arithmetic/exponent")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content("""
                                        {"operand1": 3.0, "operand2": 0.0, "exponent": 3}
                                        """))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.result").value(27.0));
    }

    @Test
    void exponent_withoutExponent_returnsBadRequest() throws Exception {
        mockMvc.perform(
                        post("/api/arithmetic/exponent")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content("""
                                {"operand1": 15.0, "operand2": 0.0}
                                """))
                .andExpect(status().isBadRequest());
    }
}