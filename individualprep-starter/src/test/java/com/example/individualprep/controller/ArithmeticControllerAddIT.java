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
public class ArithmeticControllerAddIT {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void add_returnsSum() throws Exception {
        mockMvc.perform(
                        post("/api/arithmetic/add")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content("""
                                        {"operand1": 10.0, "operand2": 5.0}
                                        """))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.result").value(15.0));
    }

    @Test
    void add_returnsDecimalSum() throws Exception {
        mockMvc.perform(
                        post("/api/arithmetic/add")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content("""
                                        {"operand1": 0.9, "operand2": 0.2}
                                        """))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.result").value(1.1));
    }
}