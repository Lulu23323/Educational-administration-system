package com.dbcon;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PersonalFileDaoImpl implements PersonalFileDao{
    Connection connection = DBUtility.getConnection("BJUT");

    public List<PersonalFileEntity> select() {
        //按信息添加顺序
        String sql = "SELECT * FROM bdic_student";
        return getPersonalFileEntities(sql);
    }

    public List<PersonalFileEntity> order() {
        //按学号升序
        String sql = "SELECT * FROM bdic_student ORDER BY account";
        return getPersonalFileEntities(sql);
    }


    public List<PersonalFileEntity> getPersonalFileEntities(String sql) {
        Object[] objects = new Object[0];
        ResultSet resultSet = DBUtility.commandQuery(this.connection, sql, objects);
        ArrayList PersonalFileEntityList = new ArrayList();
        try{
            while(resultSet.next()){
                String fullName = resultSet.getString("fullName");
                String account  =resultSet.getString("account");
                String college = resultSet.getString("college");
                String major = resultSet.getString("major");
                String classNumber = resultSet.getString("classNumber");
                String gender = resultSet.getString("gender");
                String phonenumber = resultSet.getString("phonenumber");
                String idnumber = resultSet.getString("idnumber");
                String beginage = resultSet.getString("beginage");
                String email = resultSet.getString("email");
                String introduction = resultSet.getString("introduction");
                PersonalFileEntity personalFileEntity  =new PersonalFileEntity(fullName,account,college,major,classNumber,gender,phonenumber,idnumber,beginage,email,introduction);
                PersonalFileEntityList.add(personalFileEntity);
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return PersonalFileEntityList;
    }

    public PersonalFileEntity search(String studentAccount) {
        //此处数据库 条件未改变
        String sql = "SELECT * FROM bdic_student WHERE account = ?";
        Object[] objects = new Object[]{studentAccount};
        ResultSet resultSet = DBUtility.commandQuery(this.connection, sql, objects);
        PersonalFileEntity personalFileEntity = null;

        try{
            while(resultSet.next()){
                String fullName = resultSet.getString("fullName");
                String account  =resultSet.getString("account");
                String college = resultSet.getString("college");
                String major = resultSet.getString("major");
                String classNumber = resultSet.getString("classNumber");
                String gender = resultSet.getString("gender");
                String phonenumber = resultSet.getString("phonenumber");
                String idnumber = resultSet.getString("idnumber");
                String beginage = resultSet.getString("beginage");
                String email = resultSet.getString("email");
                String introduction = resultSet.getString("introduction");
                personalFileEntity  =new PersonalFileEntity(fullName,account,college,major,classNumber,gender,phonenumber,idnumber,beginage,email,introduction);

            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return personalFileEntity;
    }


    public PersonalFileEntity addNewAccount(String account) {
        //创建新的student Entity根据account，没有检查
        return new PersonalFileEntity("",account,"","","","","","","","","");
    }

    public int update(PersonalFileEntity personalFileEntity) {
        //在bdic_student大表中根据account修改学生信息
        String sql = "UPDATE bdic_student SET  gender = ?,phonenumber = ?, idnumber = ?,beginage = ?, email = ?, introduction = ? WHERE account =?";
        Object[] objects = new Object[]{personalFileEntity.getGender(),personalFileEntity.getPhonenumber(),personalFileEntity.getIdnumber(),personalFileEntity.getBeginage(),personalFileEntity.getEmail(),personalFileEntity.getIntroduction(),personalFileEntity.getAccount()};
        int i = DBUtility.commandUpdate(this.connection,sql,objects);
        return i;
    }


    //似乎不需要PersonalFileEntity的create（）？因为不需要创建个人信息？已经又studentEntity创建了？
    public int create(PersonalFileEntity personalFileEntity) {

        return 1;
    }

    @Override
    public int delete(String account) {
        return 0;
    }
}
