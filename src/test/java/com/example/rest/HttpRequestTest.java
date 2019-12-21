package com.example.rest;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment =  WebEnvironment.RANDOM_PORT)
public class HttpRequestTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate rest;

    @Test
    void whenGetEmployeeThenSuccessful() throws Exception {
        String result = rest.getForObject(
                "http://localhost:" + port + "/employees/1",
                String.class);

        String expected = "{\"id\":1,\"name\":\"Alice\",\"role\":\"manager\"}";
        assertEquals(expected, result);
    }

    @Test
    void whenGetEmployeeThenNotFound() throws Exception {
        String result = rest.getForObject(
                "http://localhost:" + port + "employees/100",
                String.class);

        String expected = "Employee not found: 100";
        assertEquals(expected, result);
    }

}
