package com.dbcon;
import java.util.List;

public interface StudentDao {
    List<StudentEntity> getStudentEntities(String sql);

    List<StudentEntity> select();

    List<StudentEntity> order();

    StudentEntity search(String var1);

    StudentEntity addNewAccount(String account);

    int update(StudentEntity var2);

    int create(StudentEntity var2);

    int delete(String account);

}
