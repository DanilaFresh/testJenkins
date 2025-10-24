package com.example.testSpring;

import com.example.testSpring.controller.CourierController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.nio.charset.StandardCharsets;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@WebMvcTest(CourierController.class)
public class ControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void testGetTest() throws Exception {
        mockMvc.perform(get("/testGet"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(
                        MediaType.parseMediaType("text/plain;charset=UTF-8")))
                .andExpect(content().string("Test complete"));

        ;
    }
}
