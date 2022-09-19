package com.dbcon;
public class GradeDetailEntity {
    private String courseAccount;
    private String courseName;
    private String college;
    private String major;
    private String account;
    private String studentName;
    private String grade;

    private String intro;

    public String getCourseAccount() {
        return this.courseAccount;
    }

    public String getCourseName() {
        return this.courseName;
    }

    public String getCollege() {
        return this.college;
    }

    public String getMajor() {
        return this.major;
    }

    public String getAccount() {
        return this.account;
    }

    public String getStudentName() {
        return this.studentName;
    }

    public String getGrade() {
        return this.grade;
    }

    public String getIntro(){ return  this.intro;}

    public void setCourseAccount(String courseAccount) {
        this.courseAccount = courseAccount;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public void setCollege(String college) {
        this.college = college;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public void setIntro(String intro){this.intro = intro;}

    public GradeDetailEntity(String courseAccount, String courseName, String college, String major, String account, String studentName, String grade,String intro) {
        this.courseAccount = courseAccount;
        this.courseName = courseName;
        this.college = college;
        this.major = major;
        this.account = account;
        this.studentName = studentName;
        this.grade = grade;
        this.intro = intro;
    }
}
