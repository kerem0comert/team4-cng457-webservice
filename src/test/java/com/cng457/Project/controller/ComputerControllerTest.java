package com.cng457.Project.controller;

import com.cng457.Project.entity.Computer;
import com.cng457.Project.service.ComputerService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ComputerControllerTest {

    @InjectMocks
    ComputerController computerController;   // No need to use

    @Mock
    ComputerService computerService; // No need to use

    @LocalServerPort
    private int port; // No need to use

    @Autowired
    private TestRestTemplate restTemplate = new TestRestTemplate();


    @Test
    void getComputerModel() {
        assertTrue(
                this.restTemplate.getForObject("http://localhost:8080/getAllComputers", Computer[].class)[0].getModel().equals("computer1"));
    }

    @Test
    void getComputerPriceWithId() {
        assertTrue(
                this.restTemplate.getForObject("http://localhost:8080/getComputer/6", Computer.class).getPrice() == 10000);
    }

    @Test
    void getComputerScreenResolutionWithId() {
        assertTrue(
                this.restTemplate.getForObject("http://localhost:8080/getComputer/6", Computer.class).getScreenResolution().equals("1920x1080"));

    }

}
