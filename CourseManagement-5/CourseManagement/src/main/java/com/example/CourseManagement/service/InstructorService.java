package com.example.CourseManagement.service;

import com.example.CourseManagement.model.Instructor;
import com.example.CourseManagement.repository.InstructorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class InstructorService {
    private final InstructorRepository instructorRepository;
    @Autowired
    public InstructorService(InstructorRepository instructorRepository) {
        this.instructorRepository=instructorRepository;
    }
    public List<Instructor> getAllInstructor() {
        return instructorRepository.findAll();
    }
}
