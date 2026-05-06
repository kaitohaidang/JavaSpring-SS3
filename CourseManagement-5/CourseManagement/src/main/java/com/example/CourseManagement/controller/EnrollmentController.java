package com.example.CourseManagement.controller;

import com.example.CourseManagement.dto.ApiResponse;
import com.example.CourseManagement.dto.EnrollCourseRequest;
import com.example.CourseManagement.dto.EnrollmentDetail;
import com.example.CourseManagement.service.EnrollmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/enrollments")
public class EnrollmentController {

    private final EnrollmentService enrollmentService;

    @Autowired
    public EnrollmentController(EnrollmentService enrollmentService) {
        this.enrollmentService = enrollmentService;
    }

    @PostMapping("/enroll-course")
    public ResponseEntity<ApiResponse<EnrollmentDetail>> enrollCourse(@RequestBody EnrollCourseRequest request) {
        try {
            // Gọi Service để thực hiện nghiệp vụ
            EnrollmentDetail detail = enrollmentService.enrollCourse(request);

            // Nếu thành công, trả về 200 OK kèm dữ liệu
            return ResponseEntity.ok(new ApiResponse<>(true, "Đăng ký khóa học thành công!", detail));

        } catch (RuntimeException e) {
            // Bắt các lỗi nghiệp vụ từ Service và trả về 400 Bad Request
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(new ApiResponse<>(false, e.getMessage()));
        }
    }
}

