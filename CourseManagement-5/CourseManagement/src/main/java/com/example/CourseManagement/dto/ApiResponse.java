package com.example.CourseManagement.dto;

// Sử dụng <T> (Generic) để lớp này có thể bọc bất kỳ loại dữ liệu nào
public class ApiResponse<T> {
    private boolean success;
    private String message;
    private T data; // Dữ liệu thực tế được trả về

    // Constructor đầy đủ tham số
    public ApiResponse(boolean success, String message, T data) {
        this.success = success;
        this.message = message;
        this.data = data;
    }

    // Constructor cho trường hợp chỉ muốn trả về thông báo (không có dữ liệu)
    public ApiResponse(boolean success, String message) {
        this.success = success;
        this.message = message;
        this.data = null;
    }

    // Getters
    public boolean isSuccess() { return success; }
    public String getMessage() { return message; }
    public T getData() { return data; }

    // Setters
    public void setSuccess(boolean success) { this.success = success; }
    public void setMessage(String message) { this.message = message; }
    public void setData(T data) { this.data = data; }
}