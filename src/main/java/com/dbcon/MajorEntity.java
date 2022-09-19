package com.dbcon;
public class MajorEntity {
    private String majorAccount;
    private String major;
    private String college;
    private String majorIntro;

    public void setMajorAccount(String majorAccount) {
        this.majorAccount = majorAccount;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public void setCollege(String college) {
        this.college = college;
    }

    public void setMajorIntro(String majorIntro) {
        this.majorIntro = majorIntro;
    }

    public String getMajorAccount() {
        return this.majorAccount;
    }

    public String getMajor() {
        return this.major;
    }

    public String getCollege() {
        return this.college;
    }

    public String getMajorIntro() {
        return this.majorIntro;
    }

    public MajorEntity(String majorAccount, String major, String college, String majorIntro) {
        this.majorAccount = majorAccount;
        this.major = major;
        this.college = college;
        this.majorIntro = majorIntro;
    }
}
