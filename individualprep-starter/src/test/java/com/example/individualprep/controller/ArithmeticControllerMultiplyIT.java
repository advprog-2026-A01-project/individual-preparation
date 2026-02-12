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
public class ArithmeticControllerMultiplyIT {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void multiply_returnsProduct() throws Exception {
        mockMvc.perform(
                        post("/api/arithmetic/multiply")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content("""
                                {"operand1": 2.5, "operand2": 4.0}
                                """))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.result").value(10.0));
    }
}
