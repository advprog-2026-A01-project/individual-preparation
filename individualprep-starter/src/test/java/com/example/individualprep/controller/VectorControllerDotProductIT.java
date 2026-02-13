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
public class VectorControllerDotProductIT {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void dotProduct_returnsScalar() throws Exception {
        mockMvc.perform(
                post("/api/vector/dotProduct")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("""
                                {
                                    "vector1": [1.0, 2.0, 3.0],
                                    "vector2": [4.0, 5.0, 6.0]
                                }
                                """))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.scalarResult").value(32.0));
    }
}