package com.example.CourseManagement.controller;

import com.example.CourseManagement.model.Course;
import com.example.CourseManagement.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.parser.Entity;
import java.util.List;

@RestController
@RequestMapping("/api/course")
public class CourseController {
    @Autowired
    public CourseService courseService;
    public CourseController(CourseService courseService) {
        this.courseService=courseService;
    }
    @GetMapping
    public ResponseEntity<List<Course>> getAllCourse() {
        List<Course> courses= courseService.getAllCourse();
        if (courses!=null) {
            return ResponseEntity.ok(courses);
        }
        return null;
    }
    @GetMapping("/{id}")
    public ResponseEntity<Course> getCourseById(@PathVariable int id) {
        Course course= courseService.getCourseByid(id);
        if (course!=null) return ResponseEntity.ok(course);
        else  return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
    @PostMapping
    public ResponseEntity<Course> addCourse(@RequestBody Course course) {
        Course courses = courseService.addCourse(course);
        return ResponseEntity.status(HttpStatus.CREATED).body(course);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Course> updateCourse (@PathVariable int id , @RequestBody Course course) {
        Course course1= courseService.updateCourse(id,course);
        if (course1!=null)
        return  ResponseEntity.ok(course1);
        else return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
    @DeleteMapping("{id}")
    public ResponseEntity<List<Course>> deleteCourse (@PathVariable int id) {
        List<Course> courses= courseService.deleteCourse(id);
        if (courses!=null) {
            return ResponseEntity.ok(courses);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

}
