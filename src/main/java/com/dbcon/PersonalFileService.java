package com.dbcon;
import java.util.List;

public interface PersonalFileService {
    List<PersonalFileEntity> select();

    List<PersonalFileEntity> selectInOrder();

    PersonalFileEntity personalFileSearch(String account);

    int personalFileUpdate(String account, String gender, String phonenumber, String idnumber,String beginage,String emial, String introduction);


    int personalFileDelete(String account);


}
