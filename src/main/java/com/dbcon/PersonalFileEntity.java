package com.dbcon;
public class PersonalFileEntity {

    private String fullName;
    private String account;
    private String college;
    private String major;
    private String classNumber;
    private String gender;
    private String phonenumber;
    private String idnumber;
    private String beginage;
    private String email;
    private String introduction;


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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
    public String getFullName() {
        return this.fullName;
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

    public String getBeginage() {
        return beginage;
    }

    public String getGender() {
        return gender;
    }

    public String getIdnumber() {
        return idnumber;
    }

    public String getIntroduction() {
        return introduction;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setBeginage(String beginage) {
        this.beginage = beginage;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setIdnumber(String idnumber) {
        this.idnumber = idnumber;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }
    public PersonalFileEntity(String fullName, String account, String college, String major, String classNumber, String gender, String phonenumber,String idnumber, String beginage, String email, String introduction) {
        this.fullName = fullName;
        this.account = account;
        this.college = college;
        this.major = major;
        this.classNumber = classNumber;
        this.gender = gender;
        this.phonenumber = phonenumber;
        this.idnumber = idnumber;
        this.beginage = beginage;
        this.email = email;
        this.introduction = introduction;
    }
}
