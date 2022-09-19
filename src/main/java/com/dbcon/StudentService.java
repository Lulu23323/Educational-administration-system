package com.dbcon;

import java.util.List;

public interface StudentService {
    List<StudentEntity> select();

    List<StudentEntity> selectInOrder();

    boolean studentSearch(String account);

    int studentUpdate(String account, String fullName,String college,String major,String classNumber);

    int studentCreate(String account, String fullName,String college,String major,String classNumber);

    int studentDelete(String account);
}
