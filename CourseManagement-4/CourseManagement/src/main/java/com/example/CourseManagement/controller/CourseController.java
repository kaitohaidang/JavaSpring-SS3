package com.example.CourseManagement.controller;


import com.example.CourseManagement.dto.ApiResponse;
import com.example.CourseManagement.model.Course;
import com.example.CourseManagement.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/courses")
public class CourseController {

    private final CourseService courseService;

    @Autowired
    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    // 1. Lấy danh sách
    @GetMapping
    public ResponseEntity<ApiResponse<List<Course>>> getAllCourses() {
        List<Course> courses = courseService.getAllCourse();
        ApiResponse<List<Course>> response = new ApiResponse<>(true, "Lấy danh sách khóa học thành công", courses);
        return ResponseEntity.ok(response);
    }

    // 2. Lấy chi tiết theo ID
    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<Course>> getCourseById(@PathVariable int id) {
        try {
            Course course= courseService.getCourseByid(id);
            return ResponseEntity.ok(new ApiResponse<>(true, "Tìm thấy khóa học", course));

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    // 3. Tạo mới
    @PostMapping
    public ResponseEntity<ApiResponse<Course>> createCourse(@RequestBody Course course) {
        if (course == null ) {
            ApiResponse<Course> errorResponse = new ApiResponse<>(false, "Dữ liệu đầu vào không hợp lệ");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
        }
        Course createdCourse = courseService.addCourse(course);
        ApiResponse<Course> response = new ApiResponse<>(true, "Tạo khóa học thành công", createdCourse);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    // 4. Cập nhật
    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<Course>> updateCourse(@PathVariable int id, @RequestBody Course course) {
        try {
            Course updatedCourse = courseService.updateCourse(id, course);
            return ResponseEntity.ok(new ApiResponse<>(true, "Cập nhật thành công", updatedCourse));
        } catch (RuntimeException e) {
            // Bắt lỗi nếu ID không tồn tại
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(new ApiResponse<>(false, e.getMessage()));
        }
    }

    // 5. Xóa theo ID
    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Course>> deleteCourseById(@PathVariable int id) {
        try {
            List<Course> deletedCourse = courseService.deleteCourse(id);
            return ResponseEntity.ok(new ApiResponse<>(true, "Xóa thành công"));
        } catch (RuntimeException e) {
            // Bắt lỗi nếu ID không tồn tại
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(new ApiResponse<>(false, e.getMessage()));
        }
    }
}