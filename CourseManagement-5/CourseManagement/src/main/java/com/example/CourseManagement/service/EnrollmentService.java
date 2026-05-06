package com.example.CourseManagement.service;

import com.example.CourseManagement.dto.EnrollCourseRequest;
import com.example.CourseManagement.dto.EnrollmentDetail;
import com.example.CourseManagement.model.Course;
import com.example.CourseManagement.model.Enrollment;
import com.example.CourseManagement.model.Instructor;
import com.example.CourseManagement.repository.CourseRepository;
import com.example.CourseManagement.repository.EnrollmentRepository;
import com.example.CourseManagement.repository.InstructorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EnrollmentService {

    // Tiêm (Inject) nhiều Repository vào Service
    private final EnrollmentRepository enrollmentRepository;
    private final CourseRepository courseRepository;
    private final InstructorRepository instructorRepository;

    @Autowired
    public EnrollmentService(EnrollmentRepository enrollmentRepository,
                             CourseRepository courseRepository,
                             InstructorRepository instructorRepository) {
        this.enrollmentRepository = enrollmentRepository;
        this.courseRepository = courseRepository;
        this.instructorRepository = instructorRepository;
    }

    // Hàm xử lý nghiệp vụ đăng ký khóa học
    public EnrollmentDetail enrollCourse(EnrollCourseRequest request) {

        // 1. Khóa học phải tồn tại
        Course course = courseRepository.findAll(request.getCourseId())
                .orElseThrow(() -> new RuntimeException("Đăng ký thất bại: Khóa học không tồn tại."));

        // 2. Khóa học phải ở trạng thái ACTIVE
        if (!"Active".equalsIgnoreCase(course.getStatus())) {
            throw new RuntimeException("Đăng ký thất bại: Khóa học hiện không trong trạng thái ACTIVE.");
        }

        // 3. Instructor của Course phải tồn tại
        Instructor instructor = instructorRepository.findAll(course.getInstructorld())
                .orElseThrow(() -> new RuntimeException("Đăng ký thất bại: Giảng viên phụ trách khóa học không tồn tại."));

        // Nếu qua được cả 3 bước trên, tiến hành tạo Enrollment
        // Tạo ID giả lập (trong thực tế Database sẽ tự tăng ID này)
        Long newId = System.currentTimeMillis();
        Enrollment newEnrollment = new Enrollment(newId, request.getStudentName(), course.getId());

        // Lưu vào kho dữ liệu
        enrollmentRepository.create(newEnrollment);

        // Trả về DTO kết hợp dữ liệu theo yêu cầu đề bài
        return new EnrollmentDetail(newEnrollment.getId(), newEnrollment.getStudentName(), course);
    }
}@Service
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
