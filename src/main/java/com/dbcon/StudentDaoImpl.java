package com.dbcon;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentDaoImpl implements StudentDao{
    Connection connection = DBUtility.getConnection("bjut");
    

    @Override
    public List<StudentEntity> select() {
        //鎸変俊鎭坊鍔犻『搴�
        String sql = "SELECT * FROM bdic_student";
        return getStudentEntities(sql);
    }

    @Override
    public List<StudentEntity> order() {
        //鎸夊鍙峰崌搴�
        String sql = "SELECT * FROM bdic_student ORDER BY account";
        return getStudentEntities(sql);

    }
    @Override
    public List<StudentEntity> getStudentEntities(String sql) {
        Object[] objects = new Object[0];
        ResultSet resultSet = DBUtility.commandQuery(this.connection, sql, objects);
        ArrayList StudentEntityList = new ArrayList();
        try{
            while(resultSet.next()){
                String fullName = resultSet.getString("fullName");
                String account  =resultSet.getString("account");
                String college = resultSet.getString("college");
                String major = resultSet.getString("major");
                String classNumber = resultSet.getString("classNumber");
                StudentEntity studentEntity  = new StudentEntity(fullName,account,college,major,classNumber);
                StudentEntityList.add(studentEntity);
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return StudentEntityList;
    }


    @Override
    public StudentEntity search(String studentAccount) {
        //姝ゅ鏁版嵁搴� 鏉′欢鏈敼鍙�
        String sql = "SELECT * FROM bdic_student WHERE account = ?";
        Object[] objects = new Object[]{studentAccount};
        ResultSet resultSet = DBUtility.commandQuery(this.connection, sql, objects);
        StudentEntity studentEntity = null;

        try{
        	System.out.println("come here5");
            while(resultSet.next()){
            	System.out.println("come here6");
                String fullName = resultSet.getString("fullName");
               // String account  =resultSet.getString("account");
                String college = resultSet.getString("college");
                String major = resultSet.getString("major");
                String classNumber = resultSet.getString("classNumber");
                studentEntity  =new StudentEntity(fullName,studentAccount,college,major,classNumber);
                System.out.println("come here");

            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return studentEntity;
    }

    @Override
    public StudentEntity addNewAccount(String account) {
        //鍒涘缓鏂扮殑student Entity鏍规嵁account锛屾病鏈夋鏌�
        StudentEntity studentEntity = new StudentEntity("",account,"","",null);
        return studentEntity;
    }

    @Override
    public int update(StudentEntity studentEntity) {
        //鍦╞dic_student澶ц〃涓牴鎹產ccount淇敼瀛︾敓淇℃伅
        String sql = "UPDATE bdic_student SET  fullName = ?,college = ?,major = ?, classNumber= ? WHERE account =?";
        Object[] objects = new Object[]{studentEntity.getFullName(),studentEntity.getCollege(),studentEntity.getMajor(),studentEntity.getClassNumber(),studentEntity.getAccount()};
        int i = DBUtility.commandUpdate(this.connection,sql,objects);
        return i;
    }

    @Override
    public int create(StudentEntity studentEntity) {
        String sql="INSERT INTO bdic_student (Account,FullName,College,Major,ClassNumber) VALUES (?,?,?,?,?)";
        Object[] objects = new Object[]{studentEntity.getAccount(),studentEntity.getFullName(),studentEntity.getCollege(),studentEntity.getMajor(),studentEntity.getClassNumber()};
        int i = DBUtility.commandUpdate(this.connection,sql,objects);
        return i;
    }

    @Override
    public int delete(String account) {
        String sql = "DELETE FROM bdic_student WHERE account = ?";
        Object[] objects = new Object[]{account};
        int i = DBUtility.commandUpdate(this.connection,sql,objects);
        return i;
    }

    /*@Override
    public String add(String account,String fullName,String college, String major, String classNumber) {
        //鍏堟煡鐪嬫湁鏃犳璐︽埛瀛︾敓锛屽鏋滄湁 杩斿洖鍒版洿鏂�
        String sql="INSERT INTO se_student (account,fullName,college,major,classNumber) VALUES (?,?,?,?,?)";
        Object[] objects = new Object[]{account,fullName,college,major,classNumber};
        String i = DBUtility.commandUpdate(this.connection,sql,objects);

        String sql = "UPDATE se_student SET  fullName = ?,college = ?,major = ?, classNumber= ? WHERE account =?";

        return 0;
    }*/


}
