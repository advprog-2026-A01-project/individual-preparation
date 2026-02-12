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
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@AutoConfigureMockMvc
public class VectorControllerSubtractIT {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void subtract_returnsDifferenceVector() throws Exception {
        mockMvc.perform(
                        post("/api/vector/subtract")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content("""
                                {"vector1":[5,7,9], "vector2":[1,2,3]}
                                """))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.result[0]").value(4.0))
                .andExpect(jsonPath("$.result[1]").value(5.0))
                .andExpect(jsonPath("$.result[2]").value(6.0))
                .andExpect(jsonPath("$.scalarResult").value(nullValue()));
    }

    @Test
    void subtract_withNullVector_throwsException() {
        assertThrows(Exception.class, () -> {
            mockMvc.perform(
                            post("/api/vector/subtract")
                                    .contentType(MediaType.APPLICATION_JSON)
                                    .content("""
                                {"vector1":null, "vector2":[1,2,3]}
                                """))
                    .andReturn();
        });
    }

    @Test
    void subtract_differentLength_throwsException() {
        assertThrows(Exception.class, () -> {
            mockMvc.perform(
                            post("/api/vector/subtract")
                                    .contentType(MediaType.APPLICATION_JSON)
                                    .content("""
                                {"vector1":[1,2], "vector2":[1,2,3]}
                                """))
                    .andReturn();
        });
    }
}
