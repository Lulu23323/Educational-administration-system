package com.dbcon;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class GradeDaoImpl implements GradeDao {
    Connection connection = DBUtility.getConnection("BJUT");

    @Override
    public List<GradeEntity> select() {
        Object[] objects = new Object[0];
        String sql = "SELECT * FROM bdic_grade";
        ResultSet resultSet = DBUtility.commandQuery(this.connection, sql, objects);
        ArrayList GradeEntityList = new ArrayList();
        try {
            while(resultSet.next()) {
                String courseAccount = resultSet.getString("courseAccount");
                String college  =resultSet.getString("college");
                String major = resultSet.getString("major");
                String account = resultSet.getString("account");
                String grade = resultSet.getString("grade");

                GradeEntity gradeEntity = new GradeEntity(courseAccount,college,major,account,grade);

                GradeEntityList.add(gradeEntity);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return GradeEntityList;
    }
//鎴愮哗闇�瑕佹坊鍔犱竴琛岋紝search鏃跺悓鏃舵悳绱㈣绋媍ourseaccount鍜屽鐢焌ccount銆�
    @Override
    public GradeEntity search(String courseAccount, String account) {
        String sql = "SELECT * FROM bdic_grade WHERE courseAccount = ? and account = ?";
        Object[] objects = new Object[]{courseAccount, account};
        ResultSet resultSet = DBUtility.commandQuery(this.connection, sql, objects);
        GradeEntity gradeEntity = null;

        try{
            while (resultSet.next()){
                //String collegeAccount  =resultSet.getString("courseAccount");
                String college = resultSet.getString("college");
                String major = resultSet.getString("major");
                //String account = resultSet.getString("account");
                String grade = resultSet.getString("grade");
                gradeEntity = new GradeEntity(courseAccount,college,major,account,grade);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return gradeEntity;
    }

    @Override
    public List<GradeEntity> selectCourseAccount(String courseAccount) {
        String sql = "SELECT * FROM bdic_grade WHERE courseAccount = ?";
        Object[] objects = new Object[]{courseAccount};
        ResultSet resultSet = DBUtility.commandQuery(this.connection, sql, objects);

        ArrayList GradeEntityList = new ArrayList();

        try{
            while (resultSet.next()){
                String college = resultSet.getString("college");
                String major = resultSet.getString("major");
                String account = resultSet.getString("account");
                String grade = resultSet.getString("grade");
                GradeEntity gradeEntity = new GradeEntity(courseAccount,college,major,account,grade);
                GradeEntityList.add(gradeEntity);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return GradeEntityList;
    }

    @Override
    public List<GradeEntity> selectAccount( String account) {
        String sql = "SELECT * FROM bdic_grade WHERE account = ?";
        Object[] objects = new Object[]{account};
        ResultSet resultSet = DBUtility.commandQuery(this.connection, sql, objects);
        ArrayList GradeEntityList = new ArrayList();

        try{
            while (resultSet.next()){
                String courseAccount  =resultSet.getString("courseAccount");
                String college = resultSet.getString("college");
                String major = resultSet.getString("major");
                //String account = resultSet.getString("account");
                String grade = resultSet.getString("grade");
                GradeEntity gradeEntity = new GradeEntity(courseAccount,college,major,account,grade);
                GradeEntityList.add(gradeEntity);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return GradeEntityList;
    }

    @Override
    public List<GradeDetailEntity> getDetails(String courseAccount) {
        String sql = "  select *  from bdic_student,bdic_grade, course_information where bdic_student.account = bdic_grade.account AND course_information.courseAccount=? ";
        Object[] objects = new Object[]{courseAccount};
        ResultSet resultSet = DBUtility.commandQuery(this.connection, sql, objects);
        ArrayList GradeEntityList = new ArrayList();


        try{
            while (resultSet.next()){
                String courseName = resultSet.getString("course_information.course");
                String studentName = resultSet.getString("bdic_student.fullName");
                String college = resultSet.getString("college");
                String major = resultSet.getString("major");
                String account = resultSet.getString("account");
                String grade = resultSet.getString("grade");
                String intro = resultSet.getString("course_information.intro");
                GradeDetailEntity gradeDetailEntity = new GradeDetailEntity(courseAccount,courseName,college,major,account,studentName,grade,intro);
                GradeEntityList.add(gradeDetailEntity);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return GradeEntityList;
    }

    @Override
    public List<GradeDetailEntity> getDetailsByStudent(String account) {
        String sql = "  select *  from bdic_student, course_information, bdic_grade where bdic_student.account = bdic_grade.account AND course_information.courseAccount = bdic_grade.courseAccount AND bdic_student.account=? ";
        Object[] objects = new Object[]{account};
        ResultSet resultSet = DBUtility.commandQuery(this.connection, sql, objects);
        ArrayList GradeEntityList = new ArrayList();


        try{
            while (resultSet.next()){
                String courseName = resultSet.getString("course_information.course");
                String studentName = resultSet.getString("bdic_student.fullName");
                String college = resultSet.getString("college");
                String major = resultSet.getString("major");
                String courseAccount = resultSet.getString("course_information.courseAccount");
                String grade = resultSet.getString("grade");
                String intro = resultSet.getString("course_information.intro");
                GradeDetailEntity gradeDetailEntity = new GradeDetailEntity(courseAccount,courseName,college,major,account,studentName,grade,intro);
                GradeEntityList.add(gradeDetailEntity);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return GradeEntityList;
    }

    @Override
    public GradeEntity addNewAccount(String courseAccount) {
        //鍒涘缓鏂扮殑  Entity鏍规嵁account锛屾病鏈夋鏌�
        GradeEntity gradeEntity = new GradeEntity(courseAccount,"","","","");
        return gradeEntity;
    }
    @Override
    public int update(GradeEntity gradeEntity) {
        //鍦╞dic_grade澶ц〃涓牴鎹甤ourseaccount 鍜� account淇敼瀛︾敓鏌愰棬璇剧殑鎴愮哗
        String sql = "UPDATE bdic_grade SET  college = ?, major = ?, grade = ? WHERE courseAccount=? and account = ?";
        Object[] objects = new Object[]{gradeEntity.getCollege(),gradeEntity.getMajor(),gradeEntity.getGrade(),gradeEntity.getCourseAccount(),gradeEntity.getAccount()};
        int i = DBUtility.commandUpdate(this.connection,sql,objects);
        return i;
    }

    @Override
    public int create(GradeEntity gradeEntity) {
        String sql="INSERT INTO bdic_grade (courseAccount,college,major,account,grade) VALUES (?,?,?,?,?)";
        Object[] objects = new Object[]{gradeEntity.getAccount(),gradeEntity.getCollege(),gradeEntity.getMajor(),gradeEntity.getAccount(),gradeEntity.getGrade()};
        int i = DBUtility.commandUpdate(this.connection,sql,objects);
        return i;

    }

    @Override
    public int delete(String courseAccount,String account) {
        String sql = "DELETE FROM bdic_grade WHERE courseAccount = ? and account = ? ";
        Object[] objects = new Object[]{courseAccount, account};
        int i = DBUtility.commandUpdate(this.connection,sql,objects);
        return i;
    }






}
