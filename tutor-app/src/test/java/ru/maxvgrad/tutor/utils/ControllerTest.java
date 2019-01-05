package ru.maxvgrad.tutor.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.test.web.servlet.MockMvc;

@AutoConfigureMockMvc
public class ControllerTest {

    @Autowired private MockMvc mockMvc;

    public MockMvc getMockMvc() {
        return mockMvc;
    }
}
