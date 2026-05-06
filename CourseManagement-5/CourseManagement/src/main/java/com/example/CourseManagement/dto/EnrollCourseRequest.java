package com.example.CourseManagement.dto;

public class EnrollCourseRequest {
    private String studentName;
    private Long courseId;

    // Getters và Setters
    public String getStudentName() { return studentName; }
    public void setStudentName(String studentName) { this.studentName = studentName; }
    public Long getCourseId() { return courseId; }
    public void setCourseId(Long courseId) { this.courseId = courseId; }
}
