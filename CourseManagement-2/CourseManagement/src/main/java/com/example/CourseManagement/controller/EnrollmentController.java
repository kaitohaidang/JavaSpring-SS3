package com.example.CourseManagement.controller;

import com.example.CourseManagement.service.EnrollmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class EnrollmentController {
    private final EnrollmentService service;

    @Autowired // Constructor Injection
    public EnrollmentController(EnrollmentService service) {
        this.service = service;
    }
}

