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
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@AutoConfigureMockMvc
public class ArithmeticControllerDivideIT {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void divide_returnsQuotient() throws Exception {
        mockMvc.perform(
                        post("/api/arithmetic/divide")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content("""
                                {"operand1": 10.0, "operand2": 2.0}
                                """))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.result").value(5.0));
    }

    @Test
    void divide_byZero_throwsException() {
        assertThrows(Exception.class, () -> {
            mockMvc.perform(
                            post("/api/arithmetic/divide")
                                    .contentType(MediaType.APPLICATION_JSON)
                                    .content("""
                        {"operand1": 5.0, "operand2": 0.0}
                        """))
                    .andReturn();
        });
    }
}
