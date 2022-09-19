package com.dbcon;

public interface pwdDao {
    pwdEntity search(String account);

    int update(pwdEntity pwdEntity);

}
