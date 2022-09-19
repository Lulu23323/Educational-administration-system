package com.dbcon;
import java.util.List;

public interface GradeDao {
    List<GradeEntity> select();

    List<GradeEntity> selectCourseAccount(String courseAccount);

    List<GradeEntity> selectAccount(String account);

    List<GradeDetailEntity> getDetails(String courseAccount);

    List<GradeDetailEntity> getDetailsByStudent(String account);

    GradeEntity search(String courseAccount, String Account);

    GradeEntity addNewAccount(String courseAccount);

    int update(GradeEntity gradeEntity);

    int create(GradeEntity gradeEntity);

    int delete(String courseAccount, String account);


}
