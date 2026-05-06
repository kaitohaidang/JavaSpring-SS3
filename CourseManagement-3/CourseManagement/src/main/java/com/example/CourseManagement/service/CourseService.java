package com.example.CourseManagement.service;

import com.example.CourseManagement.model.Course;
import com.example.CourseManagement.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {
    private final CourseRepository courseRepository;
    @Autowired
    public CourseService (CourseRepository courseRepository) {
        this.courseRepository=courseRepository;
    }
    public List<Course> getAllCourse()
    {
        return courseRepository.findAll();
    }
    public Course getCourseByid (int id)
    {
        return courseRepository.findById(id);
    }
    public Course updateCourse(int id , Course course) {
        return courseRepository.updateCourse(id, course);
    }
    public Course addCourse(Course c) {
        return courseRepository.createCourse(c);
    }
    public List<Course> deleteCourse (int id) {
        return courseRepository.deleteCourseById(id);
    }

}
