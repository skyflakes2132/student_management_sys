package com.example.bwiset;

public class StudentList {

    private int id;
    private int school_id_number;
    private String student_name;
    private String course;
    private String year_level;

    // Constructor to initialize the fields
    public StudentList(int id, int school_id_number, String student_name, String course, String year_level) {
        this.id = id;
        this.school_id_number = school_id_number;
        this.student_name = student_name;
        this.course = course;
        this.year_level = year_level;
    }

    // Getter for id
    public int getId() {
        return id;
    }

    // Setter for id
    public void setId(int id) {
        this.id = id;
    }

    // Getter for school_id_number
    public int getSchool_id_number() {
        return school_id_number;
    }

    // Setter for school_id_number
    public void setSchool_id_number(int school_id_number) {
        this.school_id_number = school_id_number;
    }

    // Getter for student_name
    public String getStudent_name() {
        return student_name;
    }

    // Setter for student_name
    public void setStudent_name(String student_name) {
        this.student_name = student_name;
    }

    // Getter for course
    public String getCourse() {
        return course;
    }

    // Setter for course
    public void setCourse(String course) {
        this.course = course;
    }

    // Getter for year_level
    public String getYear_level() {
        return year_level;
    }

    // Setter for year_level
    public void setYear_level(String year_level) {
        this.year_level = year_level;
    }
}
