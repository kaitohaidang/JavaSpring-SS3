package com.example.CourseManagement.model;

public class Course {
    private int id;
    private String title;
    private String status;
    private int instructorld;
    public Course(int id,String title,String status,int instructorld) {
        this.id=id;
        this.title=title;
        this.status=status;
        this.instructorld=instructorld;
    }

    public int getId() {
        return id;
    }

    public int getInstructorld() {
        return instructorld;
    }

    public String getStatus() {
        return status;
    }

    public String getTitle() {
        return title;
    }
}
