
public class CourseEntity {
   private String courseAccount;
   private String course;
   private  String college;
   private String major;
   private String intro;
   public String getCourseAccount() {
      return this.courseAccount;
   }

   public String getCourse() {
      return this.course;
   }

   public String getCollege() {
      return this.college;
   }

   public String getMajor() {
      return this.major;
   }

   public String getIntro() {
      return this.intro;
   }

   public void setCourseAccount(String courseAccount) {
      this.courseAccount = courseAccount;
   }

   public void setCourse(String course) {
      this.course = course;
   }

   public void setCollege(String college) {
      this.college = college;
   }

   public void setMajor(String major) {
      this.major = major;
   }

   public void setIntro(String intro) {
      this.intro = intro;
   }

   public CourseEntity(String courseAccount, String course, String college, String major, String intro) {
      this.courseAccount = courseAccount;
      this.course = course;
      this.college = college;
      this.major = major;
      this.intro = intro;
   }
   /*
   与之前的grade表格有关
   private String courseAccount;
   private String college;
   private String major;
   private String account;
   private String grade;

   public String getCourseAccount() {
      return this.courseAccount;
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

   public String getGrade() {
      return this.grade;
   }

   public void setCourseAccount(String courseAccount) {
      this.courseAccount = courseAccount;
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

   public void setGrade(String grade) {
      this.grade = grade;
   }

   public CourseEntity(String courseAccount, String college, String major, String account, String grade) {
      this.courseAccount = courseAccount;
      this.college = college;
      this.major = major;
      this.account = account;
      this.grade = grade;
   }*/
}
