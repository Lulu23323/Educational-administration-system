
public class CollegeEntity {
    private String collegeAccount;
    private String college;
    private String collegeIntro;

    public void setCollegeAccount(String collegeAccount) {
        this.collegeAccount = collegeAccount;
    }

    public void setCollege(String college) {
        this.college = college;
    }

    public void setCollegeIntro(String collegeIntro) {
        this.collegeIntro = collegeIntro;
    }

    public String getCollegeAccount() {
        return this.collegeAccount;
    }

    public String getCollege() {
        return this.college;
    }

    public String getCollegeIntro() {
        return this.collegeIntro;
    }

    public CollegeEntity(String collegeAccount, String college, String collegeIntro) {
        this.collegeAccount = collegeAccount;
        this.college = college;
        this.collegeIntro = collegeIntro;
    }
}
