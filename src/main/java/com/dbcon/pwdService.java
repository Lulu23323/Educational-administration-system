package com.dbcon;

public interface pwdService {
    pwdEntity pwdSearch(String account);

    int pwdUpdate(String account,String password);
}
