package com.example.CourseManagement.controller;

import com.example.CourseManagement.service.InstructorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class InstructorController {
    private final InstructorService service;

    @Autowired // Constructor Injection
    public InstructorController(InstructorService service) {
        this.service = service;
    }
}
