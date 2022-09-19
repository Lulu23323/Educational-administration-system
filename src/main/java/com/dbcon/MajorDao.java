package com.dbcon;
import java.util.List;

public interface MajorDao {
    List<MajorEntity> select();

    MajorEntity search(String majorAccount);

    MajorEntity addNewAccount(String majorAccount);

    int update(MajorEntity majorEntity);

    int create(MajorEntity majorEntity);

    int delete(String majorAccount);
}
