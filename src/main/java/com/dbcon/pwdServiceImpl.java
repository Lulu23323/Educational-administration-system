package com.dbcon;

public class pwdServiceImpl implements pwdService {
    public pwdServiceImpl(){}

    @Override
    public pwdEntity pwdSearch(String account) {
        pwdDao pwdDao = new pwdDaoImpl();
        return pwdDao.search(account);
    }

    @Override
    public int pwdUpdate(String account,String password) {
        pwdDao pwdDao = new pwdDaoImpl();
        pwdEntity pwdEntity = pwdDao.search(account);
        if(pwdEntity == null){
            System.out.println("娌℃湁姝� pwd entity ");
            return 0;
        }else{
            pwdEntity.setPassword(password);
            return pwdDao.update(pwdEntity);
        }
    }
}
