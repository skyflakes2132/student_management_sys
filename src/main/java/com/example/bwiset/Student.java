package com.example.bwiset;

public class Student {
    private final int id;
    private final int schoolIdNo;
    private String name;
    private String course;
    private String yearLevel;
    private double gwa;

    // Additional fields
    private int age;
    private String gender;
    private String schoolYear;
    private String address;
    private String birthdate; // Can use LocalDate if needed
    private String contactNumber;
    private String email;
    private double balance;
    private String enrollmentStatus; // E.g., "Enrolled", "Pending"

    // Parent information
    private String parentName;
    private String parentAddress;
    private String parentContactNumber;

    // Constructor with essential fields
    public Student(int id, int schoolIdNo, String name, String course, String yearLevel, double gwa) {
        this.id = id;
        this.schoolIdNo = schoolIdNo;
        this.name = name;
        this.course = course;
        this.yearLevel = yearLevel;
        this.gwa = gwa;
    }

    // Getters and setters for new fields
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getSchoolYear() {
        return schoolYear;
    }

    public void setSchoolYear(String schoolYear) {
        this.schoolYear = schoolYear;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getEnrollmentStatus() {
        return enrollmentStatus;
    }

    public void setEnrollmentStatus(String enrollmentStatus) {
        this.enrollmentStatus = enrollmentStatus;
    }

    public String getParentName() {
        return parentName;
    }

    public void setParentName(String parentName) {
        this.parentName = parentName;
    }

    public String getParentAddress() {
        return parentAddress;
    }

    public void setParentAddress(String parentAddress) {
        this.parentAddress = parentAddress;
    }

    public String getParentContactNumber() {
        return parentContactNumber;
    }

    public void setParentContactNumber(String parentContactNumber) {
        this.parentContactNumber = parentContactNumber;
    }

    // Existing getters for core fields
    public int getId() {
        return id;
    }

    public int getSchoolIdNo() {
        return schoolIdNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getYearLevel() {
        return yearLevel;
    }

    public void setYearLevel(String yearLevel) {
        this.yearLevel = yearLevel;
    }

    public double getGwa() {
        return gwa;
    }

    public void setGwa(double gwa) {
        this.gwa = gwa;
    }
}
