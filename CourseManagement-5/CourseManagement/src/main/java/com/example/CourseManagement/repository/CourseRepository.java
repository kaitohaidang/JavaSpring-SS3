package com.example.CourseManagement.repository;

import com.example.CourseManagement.model.Course;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

    public Optional<Course> findById(int id) {
        return courses.stream()
                .filter(course -> course.getId()==id)
                .findFirst();
        }

 public Course create(Course course) {
    courses.add(course);
    return course;
}

    public Course updateCourse(int id , Course updateCourse) {
        Course existedCourse =findById(id).orElseThrow(()-> new RuntimeException("khong tim thay"));
        if (existedCourse!=null) {
            existedCourse.setTitle(updateCourse.getTitle());
            existedCourse.setInstructorld(updateCourse.getInstructorld());
            existedCourse.setStatus(updateCourse.getStatus());
        }
        return null;
    }
    public List<Course> deleteCourseById(int id) {
        Course course= findById(id).orElseThrow(()->new RuntimeException("ko tim thay"));
    if (course!=null) {
        courses.remove(course);
        return courses;
    }
    return null;
    }
}
