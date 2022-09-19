import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CourseDaoImpl implements CourseDao{
    Connection connection = DBUtility.getConnection("BJUT");

    @Override
    public List<CourseEntity> select() {
        Object[] objects = new Object[0];
        String sql = "SELECT * FROM course_information";
        ResultSet resultSet = DBUtility.commandQuery(this.connection, sql, objects);
        ArrayList CourseEntityList = new ArrayList();
        try {
            while(resultSet.next()) {
                String courseAccount = resultSet.getString("courseAccount");
                String course  =resultSet.getString("course");
                String college = resultSet.getString("college");
                String  major = resultSet.getString("major");
                String intro = resultSet.getString("intro");


                CourseEntity courseEntity = new CourseEntity(courseAccount,course, college, major,intro);

                CourseEntityList.add(courseEntity);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return CourseEntityList;
    }

    @Override
    public CourseEntity search(String courseAccount) {
        String sql = "SELECT * FROM course_information WHERE courseAccount = ?";
        Object[] objects = new Object[]{courseAccount};
        ResultSet resultSet = DBUtility.commandQuery(this.connection, sql, objects);
        CourseEntity courseEntity = null;

        try{
            while (resultSet.next()){
                String course  =resultSet.getString("course");
                String college = resultSet.getString("college");
                String major = resultSet.getString("major");
                String intro = resultSet.getString("intro");
                courseEntity = new CourseEntity(courseAccount,course,college,major,intro);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return courseEntity;
    }

    @Override
    public CourseEntity addNewAccount(String courseAccount) {
        //创建新的 Course Entity根据account，没有检查
        CourseEntity courseEntity = new CourseEntity(courseAccount,"","","","");
        return courseEntity;
    }

    @Override
    public int update(CourseEntity courseEntity) {
        //在bdic_course大表中根据account修改课程信息
        String sql = "UPDATE course_information SET course = ?, college = ?,major = ?, intro=?  WHERE courseAccount=?";
        Object[] objects = new Object[]{courseEntity.getCourse(),courseEntity.getCollege(),courseEntity.getMajor(),courseEntity.getIntro(),courseEntity.getCourseAccount()};
        int i = DBUtility.commandUpdate(this.connection,sql,objects);
        return i;
    }

    @Override
    public int create(CourseEntity courseEntity) {
        String sql="INSERT INTO course_information (courseAccount,course,college,major,intro) VALUES (?,?,?,?,?)";
        Object[] objects = new Object[]{courseEntity.getCourseAccount(),courseEntity.getCourse(),courseEntity.getCollege(),courseEntity.getMajor(),courseEntity.getIntro()};
        int i = DBUtility.commandUpdate(this.connection,sql,objects);
        return i;
    }



    @Override
    public int delete(String courseAccount) {
        String sql = "DELETE FROM course_information WHERE courseAccount = ?";
        Object[] objects = new Object[]{courseAccount};
        int i = DBUtility.commandUpdate(this.connection,sql,objects);
        return i;
    }

}
