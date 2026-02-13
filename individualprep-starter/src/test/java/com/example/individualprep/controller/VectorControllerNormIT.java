package com.example.individualprep.controller;

import static org.hamcrest.Matchers.nullValue;
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
public class VectorControllerNormIT {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void norm_returnsScalarValue() throws Exception {
        mockMvc.perform(
                        post("/api/vector/norm")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content("""
                                {"vector1":[3.0, 4.0]}"""))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.scalarResult").value(5.0))
                .andExpect(jsonPath("$.result").value(nullValue()));
    }

    @Test
    void norm_returnsCorrectValue() throws Exception {
        mockMvc.perform(
                        post("/api/vector/norm")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content("""
                                {"vector1":[-3.0, -4.0]}"""))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.scalarResult").value(5.0));
    }

    @Test
    void norm_returnsZero() throws Exception {
        mockMvc.perform(
                        post("/api/vector/norm")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content("""
                                {"vector1":[0.0, 0.0]}"""))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.scalarResult").value(0.0));
    }
}