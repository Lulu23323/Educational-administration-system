package com.dbcon;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.dbpool.DBConnection;


public class DBUtility {
    public DBUtility() {
    }

    public static Connection getConnection(String db) {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch ( ClassNotFoundException var8) {
            var8.printStackTrace();
        }

        String url = "jdbc:mysql://localhost:3306/" + db;
        String user ="root";
        String pwd = "";

        try {
            Connection connection = DriverManager.getConnection(url, user, pwd);
            return connection;
        } catch (SQLException var7) {
            var7.printStackTrace();
            return null;
        }
    }

    public static void closeResource(Connection connection) {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException var2) {
                var2.printStackTrace();
            }
        }

    }

    public static void closeResource(ResultSet resultSet) {
        if (resultSet != null) {
            try {
                resultSet.close();
            } catch (SQLException var2) {
                var2.printStackTrace();
            }
        }

    }

    public static void closeResource(Connection connection, Statement statement) {
        try {
            if (statement != null) {
                statement.close();
            }

            if (connection != null) {
                connection.close();
            }
        } catch (SQLException var3) {
            var3.printStackTrace();
        }

    }

    public static void closeResource(Connection connection, Statement statement, ResultSet resultSet) {
        try {
            if (resultSet != null) {
                resultSet.close();
            }

            if (statement != null) {
                statement.close();
            }

            if (connection != null) {
                connection.close();
            }
        } catch (SQLException var4) {
            var4.printStackTrace();
        }

    }

    public static int commandUpdate(Connection connection, String sql, Object[] objects) {
        PreparedStatement preparedStatement = null;

        try {
            preparedStatement = connection.prepareStatement(sql);

            for(int i = 1; i <= objects.length; ++i) {
                preparedStatement.setObject(i, objects[i - 1]);
            }
            return preparedStatement.executeUpdate();
        } catch (SQLException var5) {
            var5.printStackTrace();
            return -1;
        }
    }

    public static ResultSet commandQuery(Connection connection, String sql, Object[] objects) {
        PreparedStatement preparedStatement = null;

        try {
            preparedStatement = connection.prepareStatement(sql);

            for(int i = 1; i <= objects.length; ++i) {
                preparedStatement.setObject(i, objects[i - 1]);
            }

            return preparedStatement.executeQuery();
        } catch (SQLException var5) {
            var5.printStackTrace();
            return null;
        }
    }
    public static List getElementArray(String key){

        List<String> array = new ArrayList<>();
        Connection conn = null;
        Statement stmt = null;

        try{
           
        	conn = DBUtility.getConnection("BJUT");

            stmt = conn.createStatement();
            String sql = "SELECT " + key + " FROM bdic_student";
            ResultSet rs = stmt.executeQuery(sql);

            // ��������ӽ�������
            while(rs.next()){
                array.add(rs.getString(key));
            }

            // ��ɺ�ر�
            rs.close();
            stmt.close();
            conn.close();
            return array;


        }catch(SQLException se){
            // ���� JDBC ����
            se.printStackTrace();
            return array;
        }catch(Exception e){
            // ���� Class.forName ����
            e.printStackTrace();
            return array;
        }finally{
            // �ر���Դ
            try{
                if(stmt!=null) {
                    stmt.close();
                    return array;
                }
            }catch(SQLException se2){
            }// ʲô������
            try{
                if(conn!=null) {
                    conn.close();
                    return array;
                }
            }catch(SQLException se){
                se.printStackTrace();
                return array;
            }
        }
    }
    
    public static void main(String[] args) {
    	try {
    		Connection con = DBConnection.getConnection();
    		PreparedStatement pstm= con.prepareStatement("select * from bdic_student");
    		ResultSet rs = pstm.executeQuery();
    		while (rs.next()) {
    			System.out.println(rs.getInt("Account"));
    			System.out.println(rs.getString("password"));
    		}
    	}catch(Exception e){
    		e.printStackTrace();
    	}
//    	DBConnection.closeDB(rs, pstm, con);
    }
    


}
