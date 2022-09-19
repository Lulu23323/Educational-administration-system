package com.dbcon;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class pwdDaoImpl implements pwdDao {
    Connection connection = DBUtility.getConnection("BJUT");

    @Override
    public pwdEntity search(String account) {
        String sql = "SELECT * FROM bdic_student WHERE account = ?";
        Object[] objects = new Object[]{account};
        ResultSet resultSet = DBUtility.commandQuery(this.connection, sql, objects);
        pwdEntity pwdEntity = null;

        try{
            while (resultSet.next()){
                String pwd = resultSet.getString("password");

                pwdEntity = new pwdEntity(account,pwd);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return pwdEntity;
    }

    @Override
    public int update(pwdEntity pwdEntity) {
        String sql = "UPDATE bdic_student SET password = ? WHERE account = ?";
        Object[] objects = new Object[]{pwdEntity.getPassword(),pwdEntity.getAccount()};
        int i = DBUtility.commandUpdate(this.connection,sql,objects);
        return i;
    }
}
