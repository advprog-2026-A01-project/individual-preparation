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
public class VectorControllerAddIT {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void add_returnsSumVector() throws Exception {
        mockMvc.perform(
                        post("/api/vector/add")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content("""
                                {"vector1":[1,2,3], "vector2":[4,5,6], "scalar": null}"""))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.result[0]").value(5.0))
                .andExpect(jsonPath("$.result[1]").value(7.0))
                .andExpect(jsonPath("$.result[2]").value(9.0))
                .andExpect(jsonPath("$.scalarResult").value(nullValue()));
    }

    @Test
    void add_differentLength_returnsBadRequest() throws Exception {
        mockMvc.perform(
                        post("/api/vector/add")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content("""
                                {"vector1":[1,2], "vector2":[1,2,3], "scalar": null}"""))
                .andExpect(status().isBadRequest());
    }

    @Test
    void add_withNullVector_returnsBadRequest() throws Exception {
        mockMvc.perform(
                        post("/api/vector/add")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content("""
                                {"vector1":[1,2,3], "vector2": null, "scalar": null}"""))
                .andExpect(status().isBadRequest());
    }
}
