package com.dbcon;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MajorDaoImpl implements MajorDao{
    Connection connection = DBUtility.getConnection("BJUT");

    @Override
    public List<MajorEntity> select() {
        Object[] objects = new Object[0];
        String sql = "SELECT * FROM major_information";
        ResultSet resultSet = DBUtility.commandQuery(this.connection, sql, objects);
        ArrayList MajorEntityList = new ArrayList();
        try {
            while(resultSet.next()) {
                String majorAccount = resultSet.getString("majorAccount");
                String college = resultSet.getString("college");
                String  major = resultSet.getString("major");
                String intro = resultSet.getString("majorIntro");


                MajorEntity majorEntity = new MajorEntity(majorAccount,major,college,intro);

                MajorEntityList.add(majorEntity);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return MajorEntityList;
    }

    @Override
    public MajorEntity search(String majorAccount) {
        String sql = "SELECT * FROM major_information WHERE majorAccount = ?";
        Object[] objects = new Object[]{majorAccount};
        ResultSet resultSet = DBUtility.commandQuery(this.connection, sql, objects);
        MajorEntity majorEntity = null;

        try{
            while (resultSet.next()){
                String college = resultSet.getString("college");
                String major = resultSet.getString("major");
                String intro = resultSet.getString("majorIntro");
                majorEntity = new MajorEntity(majorAccount,major,college,intro);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return majorEntity;
    }

    @Override
    public MajorEntity addNewAccount(String majorAccount) {
        MajorEntity majorEntity = new MajorEntity(majorAccount,"","","");
        return majorEntity;
    }

    @Override
    public int update(MajorEntity majorEntity) {
        String sql = "UPDATE major_information SET major = ?, college = ?, majorIntro = ? WHERE majorAccount = ?";
        Object[] objects = new Object[]{majorEntity.getMajor(),majorEntity.getCollege(),majorEntity.getMajorIntro(),majorEntity.getMajorAccount()};
        int i = DBUtility.commandUpdate(this.connection,sql,objects);
        return i;
    }

    @Override
    public int create(MajorEntity majorEntity) {
        String sql="INSERT INTO major_information (majorAccount,major,college,majorIntro) VALUES (?,?,?,?)";
        Object[] objects = new Object[]{majorEntity.getMajorAccount(),majorEntity.getMajor(),majorEntity.getCollege(),majorEntity.getMajorIntro()};
        int i = DBUtility.commandUpdate(this.connection,sql,objects);
        return i;
    }

    @Override
    public int delete(String majorAccount) {
        String sql = "DELETE FROM major_information WHERE majorAccount = ?";
        Object[] objects = new Object[]{majorAccount};
        int i = DBUtility.commandUpdate(this.connection,sql,objects);
        return i;
    }
}
