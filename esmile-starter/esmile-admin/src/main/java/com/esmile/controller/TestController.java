package com.esmile.controller;

import com.esmile.actuator.dto.HealthCheckResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Objects;

/**
 * @Classname TestController
 * @Description TODO
 * @Version 1.0.0
 * @Date 10/3/2023 下午4:28
 * @Created by nisran
 */
@RestController
public class TestController {

    @GetMapping("hello")
    public String hello(){
        RestTemplate restTemplate = new RestTemplate();
        String healURL = "http://localhost:8010/actuator/health";
        ResponseEntity<HealthCheckResponse> response = restTemplate.getForEntity(healURL, HealthCheckResponse.class);
        // Assertions.assertEquals(response.getStatusCode(), HttpStatus.OK);
        return Objects.requireNonNull(response.getBody()).toString();
    }
}
