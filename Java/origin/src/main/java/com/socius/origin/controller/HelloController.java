package com.socius.origin.controller;

import com.socius.origin.dto.response.ApiResponse;
import com.socius.origin.dto.response.ApiResponseBuilder;
import com.socius.origin.service.HelloService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * HelloController
 */
@RestController
public class HelloController {
    private final HelloService helloservice;

    public HelloController (HelloService helloservice) {
        this.helloservice = helloservice;
    }

    @GetMapping("/hello")
    public ApiResponse<String> hello() {
        return ApiResponseBuilder.success("Hello message retrieved successfully",helloservice.helloMessage());
    }

    @GetMapping("/about")
    public ApiResponse<String> about() {
        return ApiResponseBuilder.success("About message retrieved successfully",helloservice.aboutMessage());
    }
};
