package com.dbcon;
import java.util.List;

public interface GradeService {
    List<GradeEntity> select();

    List<GradeEntity> selectByCourseAccount(String courseAccount);

    List<GradeEntity> selectByAccount(String Account);

    List<GradeDetailEntity> getDetails(String courseAccount);

    List<GradeDetailEntity> getDetailsByStudent(String account);

    GradeEntity gradeSearch(String courseAccount, String Account);

    int gradeUpdate(String courseAccount, String Account,String grade);

    int gradeCreate(String courseAccount, String Account, String college,String major, String grade);

    int gradeDelete(String courseAccount, String Account);


}
