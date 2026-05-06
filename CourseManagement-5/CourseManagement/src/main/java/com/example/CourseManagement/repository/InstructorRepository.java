package com.example.CourseManagement.repository;

import com.example.CourseManagement.model.Instructor;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
@Repository
public class InstructorRepository {
    public List<Instructor> instructors= new ArrayList<>();
    public InstructorRepository() {
        instructors.add(new Instructor(1, "Nguyễn Văn A", "nva@example.com"));
        instructors.add(new Instructor(2, "Trần Thị B", "ttb@example.com"));
    }
    public List<Instructor> findAll() {
        return instructors;
    }
}
