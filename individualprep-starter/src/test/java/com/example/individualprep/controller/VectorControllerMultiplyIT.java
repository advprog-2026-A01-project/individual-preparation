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
public class VectorControllerMultiplyIT {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void multiply_returnsScaledVector() throws Exception {
        mockMvc.perform(
                post("/api/vector/multiply")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("""
                                {"vector1":[1,2,3], "vector2": null, "scalar": 2}"""))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.result[0]").value(2.0))
                .andExpect(jsonPath("$.result[1]").value(4.0))
                .andExpect(jsonPath("$.result[2]").value(6.0))
                .andExpect(jsonPath("$.scalarResult").value(nullValue()));
    }

    @Test
    void multiply_withoutScalar_returnsBadRequest() throws Exception {
        mockMvc.perform(
                post("/api/vector/multiply")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("""
                                {"vector1":[1,2,3], "vector2": null}"""))
                .andExpect(status().isBadRequest());
    }

}
