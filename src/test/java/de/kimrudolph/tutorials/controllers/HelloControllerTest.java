package de.kimrudolph.tutorials.controllers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

import org.junit.Test;

public class HelloControllerTest {

    @Test
    public void testHelloRequest() throws Exception {
        standaloneSetup(new HelloController()).build().perform(get("/hello"))
            .andExpect(status().isOk())
            .andExpect(content().contentType("text/plain;charset=ISO-8859-1"))
            .andExpect(content().string("Hello world!"));
    }
}