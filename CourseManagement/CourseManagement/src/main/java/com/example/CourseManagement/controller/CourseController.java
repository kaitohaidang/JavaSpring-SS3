package com.example.CourseManagement.controller;

import com.example.CourseManagement.service.CourseService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CourseController {
    public CourseService courseService;
    public CourseController(CourseService courseService) {
        this.courseService=courseService;
    }
}
