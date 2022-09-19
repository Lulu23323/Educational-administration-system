import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class CollegeDaoImpl implements CollegeDao{
    Connection connection = DBUtility.getConnection("BJUT");

    @Override
    public List<CollegeEntity> select() {
        Object[] objects = new Object[0];
        String sql = "SELECT * FROM college_information";
        ResultSet resultSet = DBUtility.commandQuery(this.connection, sql, objects);
        ArrayList CollegeEntityList = new ArrayList();
        try {
            while(resultSet.next()) {
                String collegeAccount = resultSet.getString("collegeAccount");
                String college  =resultSet.getString("college");
                String collegeIntro = resultSet.getString("collegeIntro");


                CollegeEntity collegeEntity = new CollegeEntity(collegeAccount,college,collegeIntro);

                CollegeEntityList.add(collegeEntity);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return CollegeEntityList;
    }

    @Override
    public CollegeEntity search(String collegeAccount) {
        String sql = "SELECT * FROM college_information WHERE collegeAccount = ?";
        Object[] objects = new Object[]{collegeAccount};
        ResultSet resultSet = DBUtility.commandQuery(this.connection, sql, objects);
        CollegeEntity collegeEntity = null;

        try{
            while (resultSet.next()){
                String college  =resultSet.getString("college");
                String collegeIntro = resultSet.getString("collegeIntro");
                collegeEntity = new CollegeEntity(collegeAccount,college,collegeIntro);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return collegeEntity;
    }

    @Override
    public CollegeEntity addNewAccount(String collegeAccount) {
        //创建新的 College Entity根据account，没有检查
        CollegeEntity collegeEntity = new CollegeEntity(collegeAccount,"","");
        return collegeEntity;
    }

    @Override
    public int update(CollegeEntity collegeEntity) {
        //在bdic_college大表中根据account修改课程信息
        String sql = "UPDATE college_information SET college = ?, collegeIntro=?  WHERE collegeAccount=?";
        Object[] objects = new Object[]{collegeEntity.getCollege(),collegeEntity.getCollegeIntro(),collegeEntity.getCollegeAccount()};
        int i = DBUtility.commandUpdate(this.connection,sql,objects);
        return i;
    }

    @Override
    public int create(CollegeEntity collegeEntity) {
        String sql="INSERT INTO college_information (collegeAccount,college,collegeIntro) VALUES (?,?,?)";
        Object[] objects = new Object[]{collegeEntity.getCollegeAccount(),collegeEntity.getCollege(),collegeEntity.getCollegeIntro()};
        int i = DBUtility.commandUpdate(this.connection,sql,objects);
        return i;
    }



    @Override
    public int delete(String collegeAccount) {
        String sql = "DELETE FROM college_information WHERE collegeAccount = ?";
        Object[] objects = new Object[]{collegeAccount};
        int i = DBUtility.commandUpdate(this.connection,sql,objects);
        return i;
    }

}
