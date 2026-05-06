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

    public void setId(int id) {
        this.id = id;
    }

    public void setInstructorld(int instructorld) {
        this.instructorld = instructorld;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
