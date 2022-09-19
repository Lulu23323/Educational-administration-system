package com.dbcon;
import java.util.List;

public interface MajorService {
    List<MajorEntity> select();

    boolean majorSearch(String majorAccount);

    int majorUpdate(String majorAccount,String major,String college, String majorIntro);

    int majorCreate(String majorAccount,String major,String college, String majorIntro);

    int majorDelete(String majorAccount);
}
