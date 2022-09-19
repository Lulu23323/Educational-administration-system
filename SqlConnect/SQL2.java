import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
//增删改功能
public class SQL {
    public static void main(String[] args) throws ClassNotFoundException, SQLException{
        Class.forName("com.mysql.cj.jdbc.Driver");

        //构建连接参数
        String dbUrl = "jdbc:mysql://localhost:3306/BJUT";
        String dbUserName ="root";
        String dbPassword="Lily123!";



        //获取连接对象
        Connection connection = DriverManager.getConnection(dbUrl,dbUserName,dbPassword);
        //获取执行者
        Statement statement = connection.createStatement();


        //判断连接对象
        if(connection == null){
            System.out.println("数据库连接失败");
        } else {
            System.out.println("数据库连接成功");

            Statement statement1 = connection.createStatement();

            //Student
            String sql0 = "CREATE TABLE bdic_student( " +
                    "        Account varchar(200) PRIMARY KEY NOT NULL COMMENT 'StudentNumber'," +
                    "        Password varchar(200) NOT NULL COMMENT 'Password'," +
                    "        College varchar(200) NOT NULL COMMENT 'College'," +
                    "        FullName varchar(200) NOT NULL COMMENT 'StudentName',"  +
                    "        Major varchar(200) DEFAULT NULL COMMENT 'Major'," +
                    "        ClassNumber int(20) DEFAULT NULL COMMENT 'ClassNumber'," +
                    "        Gender varchar(200) DEFAULT NULL COMMENT 'Gender'," +
                    "        PhoneNumber varchar(200) DEFAULT NULL COMMENT 'PhoneNumber'," +
                    "        IDNumber varchar(200) DEFAULT NULL COMMENT 'IDNumber'," +
                    "        beginage  varchar(200) DEFAULT NULL  , " +
                    "        email  varchar(200) DEFAULT NULL ,  "+
                    "        introduction varchar(8000) DEFAULT NULL  "+
                   // "        FOREIGN KEY (Account) REFERENCES bdic_grade(Account) ON UPDATE CASCADE ON DELETE CASCADE   "+
                    ")";

            String sql01= "INSERT INTO bdic_student (Account,Password,College,FullName,Major,ClassNumber) VALUES ('20372101','123456','BDIC','Frank','SE',1),('20372102','123456','BDIC','Denny','SE',1),('20372103','123456','BDIC','Depp','SE',1),('20372104','123456','BDIC','Lily','SE',1),('20372105','123456','BDIC','Mike','SE',1),('20372106','123456','BDIC','Rose','SE',1)," +
                    "('20372201','123456','BDIC','Judy','SE',2),('20372202','123456','BDIC','Lanny','SE',2),('20372203','123456','BDIC','Ben','SE',2),('20372204','123456','BDIC','Harry','SE',2),('20372205','123456','BDIC','Simon','SE',2),('20372206','123456','BDIC','Kenny','SE',2)," +
                    "('20372301','123456','BDIC','John','SE',3),('20372302','123456','BDIC','Bella','SE',3),('20372303','123456','BDIC','Cillian','SE',3),('20372304','123456','BDIC','Tom','SE',3),('20372305','123456','BDIC','Grace','SE',3),('20372306','123456','BDIC','Tommy','SE',3)";
            String sql001= "INSERT INTO bdic_student (Account,Password,College,FullName,Major,ClassNumber) VALUES ('20373101','123456','BDIC','Sue','FIN',1),('20373102','123456','BDIC','Tommy','FIN',1),('20373103','123456','BDIC','Heard','FIN',1),('20373104','123456','BDIC','Smooth','FIN',1),('20373105','123456','BDIC','Tenra','FIN',1),('20373106','123456','BDIC','Cooper','FIN',1)," +
                    "('20373201','123456','BDIC','Peter','FIN',2),('20373202','123456','BDIC','Steven','FIN',2),('20373203','123456','BDIC','Hellen','FIN',2),('20373204','123456','BDIC','Jenny','FIN',2),('20373205','123456','BDIC','','FIN',2),('20373206','123456','BDIC','Kenny','FIN',2)," +
                    "('20373301','123456','BDIC','Tom','FIN',3),('20373302','123456','BDIC','David','FIN',3),('20373303','123456','BDIC','Selena','FIN',3),('20373304','123456','BDIC','Tom','FIN',3),('20373305','123456','BDIC','Lamer','FIN',3),('20373306','123456','BDIC','Khloe','FIN',3)";

            String sql002= "INSERT INTO bdic_student (Account,Password,College,FullName,Major,ClassNumber) VALUES ('20371101','123456','BDIC','Monica','IOT',1),('20371102','123456','BDIC','Tommy','IOT',1),('20371103','123456','BDIC','Heard','IOT',1),('20371104','123456','BDIC','Smith','IOT',1),('20371105','123456','BDIC','Kat','IOT',1),('20371106','123456','BDIC','Candice','IOT',1)," +
                    "('20371201','123456','BDIC','Rachael','IOT',2),('20371202','123456','BDIC','Jane','IOT',2),('20371203','123456','BDIC','Hellen','IOT',2),('20371204','123456','BDIC','Lily','IOT',2),('20371205','123456','BDIC','Doggy','IOT',2),('20371206','123456','BDIC','Kim','IOT',2)";




            String sql15 = "CREATE TABLE Administrator (" +
                    "  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'MainKey'," +
                    "  `Username` varchar(100) NOT NULL COMMENT 'Username'," +
                    "  `Password` varchar(100) NOT NULL COMMENT 'Password'," +
                    "  `Role` varchar(100) DEFAULT '管理员' COMMENT 'Role'," +
                    "  `ConstructTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT 'ConstructTime'," +
                    "  PRIMARY KEY (`id`))";
            String sql16 = "INSERT INTO Administrator VALUES (0,'Administrator','123456','Administrator','2021-02-26 03:37:25')";



            //Course
            String sql1 =
                    "CREATE TABLE bdic_grade( " +
                            "        CourseAccount varchar(200) NOT NULL COMMENT 'CourseAccount'," +
                            "        College varchar(200) NOT NULL COMMENT 'College'," +
                            "        Major varchar(200) DEFAULT NULL COMMENT 'Major'," +
                            "        Account varchar(200) NOT NULL COMMENT 'StudentNumber'," +
                            "        Grade varchar(20) DEFAULT NULL COMMENT 'Grade'," +
                            "        FOREIGN KEY (Account) REFERENCES bdic_student(Account) ON UPDATE CASCADE ON DELETE CASCADE,"+
                            "        FOREIGN KEY (CourseAccount) REFERENCES course_information(courseAccount) ON UPDATE CASCADE ON DELETE CASCADE,"+
                            "        PRIMARY KEY (Account,CourseAccount)"+

                            ")";

            String sql101 =
                    "CREATE TABLE BDIC_FIN_Course( " +
                            "        CourseAccount varchar(200) NOT NULL COMMENT 'CourseAccount'," +
                            "        College varchar(200) NOT NULL COMMENT 'College'," +
                            "        Major varchar(200) DEFAULT NULL COMMENT 'Major'," +
                            "        Account varchar(200) NOT NULL COMMENT 'StudentNumber'," +
                            "        Grade varchar(20) DEFAULT NULL COMMENT 'Grade'" +
                            ")";
            String sql102 =
                    "CREATE TABLE BDIC_IOT_Course( " +
                            "        CourseAccount varchar(200) NOT NULL COMMENT 'CourseAccount'," +
                            "        College varchar(200) NOT NULL COMMENT 'College'," +
                            "        Major varchar(200) DEFAULT NULL COMMENT 'Major'," +
                            "        Account varchar(200) NOT NULL COMMENT 'StudentNumber'," +
                            "        Grade varchar(20) DEFAULT NULL COMMENT 'Grade'" +
                            ")";

            String sql121= "INSERT INTO bdic_grade VALUES ('2208J','BDIC','IOT', '20371101', 'A'),('2208J','BDIC','IOT', '20371102', 'A'),('2208J','BDIC','IOT', '20371103', 'B'),('2208J','BDIC','IOT', '20371104', 'C'),('2208J','BDIC','IOT', '20371105', 'D'),('2208J','BDIC','IOT', '20371106', 'F')," +
                    "('2208J','BDIC','IOT', '20371201', 'A'),('2208J','BDIC','IOT', '20371202', 'A'),('2208J','BDIC','IOT', '20371203', 'B'),('2208J','BDIC','IOT', '20371204','B'),('2208J','BDIC','IOT', '20371205', 'C'),('2208J','BDIC','IOT', '20371206', 'D')," +

                    "('2219J','BDIC','IOT', '20371101', 'A'),('2219J','BDIC','IOT', '20371102', 'A'),('2219J','BDIC','IOT', '20371103', 'B'),('2219J','BDIC','IOT', '20371104', 'B'),('2219J','BDIC','IOT', '20371105', 'C'),('2219J','BDIC','IOT', '20371106', 'D')," +
                    "('2219J','BDIC','IOT', '20371201', 'A'),('2219J','BDIC','IOT', '20371202', 'B'),('2219J','BDIC','IOT', '20371203', 'B'),('2219J','BDIC','IOT', '20371204', 'D'),('2219J','BDIC','IOT', '20371205', 'D'),('2219J','BDIC','IOT', '20371206', 'F')," +

                    "('2213J','BDIC','IOT', '20371101', 'A'),('2213J','BDIC','IOT', '20371102', 'A'),('2213J','BDIC','IOT', '20371103', 'B'),('2213J','BDIC','IOT', '20371104', 'B'),('2213J','BDIC','IOT', '20371105', 'C'),('2213J','BDIC','IOT', '20371106', 'D')," +
                    "('2213J','BDIC','IOT', '20371201', 'A'),('2213J','BDIC','IOT', '20371202', 'A'),('2213J','BDIC','IOT', '20371203', 'B'),('2213J','BDIC','IOT', '20371204', 'B'),('2213J','BDIC','IOT', '20371205', 'C'),('2213J','BDIC','IOT', '20371206', 'F')"
                    ;


            String sql11= "INSERT INTO bdic_grade VALUES ('2008J','BDIC','SE', '20372101', 'A'),('2008J','BDIC','SE', '20372102','B'),('2008J','BDIC','SE', '20372103','B'),('2008J','BDIC','SE', '20372104','B'),('2008J','BDIC','SE', '20372105','B'),('2008J','BDIC','SE', '20372106','B')," +
                    "('2008J','BDIC','SE' ,'20372201','A'),('2008J','BDIC','SE' ,'20372202','B'),('2008J','BDIC','SE' ,'20372203','C'),('2008J','BDIC','SE' ,'20372204','C'),('2008J','BDIC','SE' ,'20372205','D'),('2008J','BDIC','SE' ,'20372206','F')," +
                    "('2008J','BDIC','SE','20372301','A'),('2008J','BDIC','SE','20372302','B'),('2008J','BDIC','SE','20372303','C'),('2008J','BDIC','SE' ,'20372304','C'),('2008J','BDIC','SE','20372305','D'),('2008J','BDIC','SE','20372306','F'),"+

                    "('2019J','BDIC','SE', '20372101', 'A'),('2019J','BDIC','SE', '20372102','A'),('2019J','BDIC','SE', '20372103','B'),('2019J','BDIC','SE', '20372104','B'),('2019J','BDIC','SE', '20372105','B'),('2019J','BDIC','SE', '20372106','B')," +
                    "('2019J','BDIC','SE' ,'20372201','A'),('2019J','BDIC','SE' ,'20372202','B'),('2019J','BDIC','SE' ,'20372203','C'),('2019J','BDIC','SE' ,'20372204','C'),('2019J','BDIC','SE' ,'20372205','D'),('2019J','BDIC','SE' ,'20372206','F')," +
                    "('2019J','BDIC','SE','20372301','A'),('2019J','BDIC','SE','20372302','B'),('2019J','BDIC','SE','20372303','C'),('2019J','BDIC','SE' ,'20372304','D'),('2019J','BDIC','SE','20372305','D'),('2019J','BDIC','SE','20372306','F')," +

                    "('2013J','BDIC','SE', '20372101', 'A'),('2013J','BDIC','SE', '20372102','B'),('2013J','BDIC','SE', '20372103','B'),('2013J','BDIC','SE', '20372104','B'),('2013J','BDIC','SE', '20372105','B'),('2013J','BDIC','SE', '20372106','C')," +
                    "('2013J','BDIC','SE' ,'20372201','A'),('2013J','BDIC','SE' ,'20372202','C'),('2013J','BDIC','SE' ,'20372203','C'),('2013J','BDIC','SE' ,'20372204','C'),('2013J','BDIC','SE' ,'20372205','C'),('2013J','BDIC','SE' ,'20372206','C')," +
                    "('2013J','BDIC','SE','20372301','B'),('2013J','BDIC','SE','20372302','C'),('2013J','BDIC','SE','20372303','D'),('2013J','BDIC','SE' ,'20372304','D'),('2013J','BDIC','SE','20372305','D'),('2013J','BDIC','SE','20372306','F')"
                    ;

            String sql12= "INSERT INTO bdic_grade VALUES ('2108J','BDIC','FIN', '20373101', 'A'),('2108J','BDIC','FIN', '20373102','A'),('2108J','BDIC','FIN', '20373103','A'),('2108J','BDIC','FIN', '20373104','B'),('2108J','BDIC','FIN', '20373105','B'),('2108J','BDIC','FIN', '20373106','B')," +
                    "('2108J','BDIC','FIN' ,'20373201','B'),('2108J','BDIC','FIN' ,'20373202','B'),('2108J','BDIC','FIN' ,'20373203','C'),('2108J','BDIC','FIN' ,'20373204','C'),('2108J','BDIC','FIN' ,'20373205','C'),('2108J','BDIC','FIN','20373206','C')," +
                    "('2108J','BDIC','FIN','20373301','C'),('2108J','BDIC','FIN','20373302','C'),('2108J','BDIC','FIN','20373303','D'),('2108J','BDIC','FIN' ,'20373304','D'),('2108J','BDIC','FIN','20373305','F'),('2108J','BDIC','FIN','20373306','F'),"+

                    "('2119J','BDIC','FIN', '20373101', 'A'),('2119J','BDIC','FIN', '20373102','A'),('2119J','BDIC','FIN', '20373103','B'),('2119J','BDIC','FIN', '20373104','C'),('2119J','BDIC','FIN', '20373105','D'),('2119J','BDIC','FIN', '20373106','F')," +
                    "('2119J','BDIC','FIN' ,'20373201','A'),('2119J','BDIC','FIN' ,'20373202','B'),('2119J','BDIC','FIN' ,'20373203','C'),('2119J','BDIC','FIN' ,'20373204','C'),('2119J','BDIC','FIN' ,'20373205','D'),('2119J','BDIC','FIN' ,'20373206','F')," +
                    "('2119J','BDIC','FIN','20373301','A'),('2119J','BDIC','FIN','20373302','B'),('2119J','BDIC','FIN','20373303','C'),('2119J','BDIC','FIN' ,'20373304','C'),('2119J','BDIC','FIN','20373305','D'),('2119J','BDIC','FIN','20373306','B')," +

                    "('2113J','BDIC','FIN', '20373101', 'A'),('2113J','BDIC','FIN', '20373102','B'),('2113J','BDIC','FIN', '20373103','C'),('2113J','BDIC','FIN', '20373104','C'),('2113J','BDIC','FIN', '20373105','C'),('2113J','BDIC','FIN', '20373106','F')," +
                    "('2113J','BDIC','FIN' ,'20373201','A'),('2113J','BDIC','FIN' ,'20373202','B'),('2113J','BDIC','FIN' ,'20373203','C'),('2113J','BDIC','FIN' ,'20373204','C'),('2113J','BDIC','FIN','20373205','F'),('2113J','BDIC','FIN' ,'20373206','F')," +
                    "('2113J','BDIC','FIN','20373301','B'),('2113J','BDIC','FIN','20373302','B'),('2113J','BDIC','FIN','20373303','C'),('2113J','BDIC','FIN' ,'20373304','C'),('2113J','BDIC','FIN','20373305','F'),('2113J','BDIC','FIN','20373306','C')"
                    ;

            //Grade
            //似乎不需要建
            //直接 "select CourseAccount, Grade from SE_Course where account = '20372101'"; 打出个人成绩单





            if(statement1.executeUpdate(sql121) >= 1){
                System.out.println("数据插入成功");
            }else{
                System.out.println("数据插入失败");
            }
            connection.close();
        }
    }}

