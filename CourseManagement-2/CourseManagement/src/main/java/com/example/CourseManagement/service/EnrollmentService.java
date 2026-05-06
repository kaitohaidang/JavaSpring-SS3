package com.example.CourseManagement.service;

import com.example.CourseManagement.model.Enrollment;
import com.example.CourseManagement.repository.EnrollmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnrollmentService {
    private final EnrollmentRepository enrollmentRepository;
    @Autowired
    public EnrollmentService(EnrollmentRepository enrollmentRepository) {
        this.enrollmentRepository=enrollmentRepository;
    }
    public List<Enrollment> getAllEnrollment() {
        return enrollmentRepository.findAll();
    }
}
