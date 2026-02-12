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
public class ArithmeticControllerSubtractIT {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void subtract_returnsDifference() throws Exception {
        mockMvc.perform(
                post("/api/arithmetic/subtract")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("""
                                {"operand1": 10.0, "operand2": 4.5}
                                """))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.result").value(5.5));
    }
}