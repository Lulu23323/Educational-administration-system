package com.dbcon;

//@AllArgsConstructor
public class StudentEntity {
/*
    private Integer id; //auto increment
    private String constructTime;
    private String studentNumber;
    private String password;
    private String studentName;
    private String headPortrait;
    private String gender;
    private int age;
    private String major;
    private String classNumber;
    private String phoneNumber;
    private String IDNumber;
    private int mode;//是否登陆过*/

    private String fullName;
    private String account;
    //private String password;
    private String college;
    private String major;
    private String classNumber;

    public String getFullName() {
        return this.fullName;
    }

    public String getAccount() {
        return this.account;
    }

    public String getCollege() {
        return this.college;
    }

    public String getMajor() {
        return this.major;
    }

    public String getClassNumber() {
        return this.classNumber;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public void setCollege(String college) {
        this.college = college;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public void setClassNumber(String classNumber) {
        this.classNumber = classNumber;
    }

    public StudentEntity(String fullName, String account, String college, String major, String classNumber) {
        this.fullName = fullName;
        this.account = account;
        this.college = college;
        this.major = major;
        this.classNumber = classNumber;
    }

}
