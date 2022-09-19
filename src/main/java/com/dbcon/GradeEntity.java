package com.dbcon;
public class GradeEntity {
    private String courseAccount;
    private String college;
    private String major;
    private String account;
    private String grade;

    public void setMajor(String major) {
        this.major = major;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public void setCourseAccount(String courseAccount) {
        this.courseAccount = courseAccount;
    }

    public void setCollege(String college) {
        this.college = college;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getMajor() {
        return major;
    }

    public String getCourseAccount() {
        return courseAccount;
    }

    public String getCollege() {
        return college;
    }

    public String getAccount() {
        return account;
    }

    public String getGrade() {
        return grade;
    }

    public GradeEntity(String CourseAccount, String college, String major, String account, String grade){
        this.courseAccount = CourseAccount;
        this.college = college;
        this.major = major;
        this.account = account;
        this.grade = grade;
    }
}
