package com.example.CourseManagement.repository;

import com.example.CourseManagement.model.Course;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
@Repository
public class CourseRepository {
    public List<Course> courses = new ArrayList<>();
    public CourseRepository() {
        courses.add(new Course(101, "Lập trình Java Cơ Bản", "Active", 1));
        courses.add(new Course(102, "Cơ sở dữ liệu", "Active", 2));
    }
    public List<Course> findAll() {
        return courses;
    }
}
