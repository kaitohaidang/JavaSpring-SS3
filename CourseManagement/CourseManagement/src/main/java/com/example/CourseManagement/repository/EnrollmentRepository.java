package com.example.CourseManagement.repository;

import com.example.CourseManagement.model.Enrollment;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
@Repository
public class EnrollmentRepository {
    public List<Enrollment> enrollments= new ArrayList<>();
    public EnrollmentRepository() {
        enrollments.add(new Enrollment(1001, "Học viên X", 101));
        enrollments.add(new Enrollment(1002, "Học viên Y", 101));
    }
    public List<Enrollment> findAll() {
        return enrollments;
    }
}
