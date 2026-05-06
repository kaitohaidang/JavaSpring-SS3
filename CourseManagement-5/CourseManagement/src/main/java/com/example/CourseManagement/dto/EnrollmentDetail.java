package com.example.CourseManagement.dto;

import com.example.CourseManagement.model.Course;

public class EnrollmentDetail {
    private Long enrollmentId;
    private String studentName;
    private Course course;

    public EnrollmentDetail(Long enrollmentId, String studentName, Course course) {
        this.enrollmentId = enrollmentId;
        this.studentName = studentName;
        this.course = course;
    }

    // Getters và Setters
    public Long getEnrollmentId() { return enrollmentId; }
    public void setEnrollmentId(Long enrollmentId) { this.enrollmentId = enrollmentId; }
    public String getStudentName() { return studentName; }
    public void setStudentName(String studentName) { this.studentName = studentName; }
    public Course getCourse() { return course; }
    public void setCourse(Course course) { this.course = course; }
}
