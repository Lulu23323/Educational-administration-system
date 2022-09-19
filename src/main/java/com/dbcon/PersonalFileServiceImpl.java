package com.dbcon;

import java.util.List;

public class PersonalFileServiceImpl implements PersonalFileService {
    public PersonalFileServiceImpl(){

    }

    public List<PersonalFileEntity> select() {
        PersonalFileDao personalFileDao = new PersonalFileDaoImpl();
        List<PersonalFileEntity> personalFileEntityList = personalFileDao.select();
        return personalFileEntityList;
    }


    public List<PersonalFileEntity> selectInOrder() {
        PersonalFileDao personalFileDao = new PersonalFileDaoImpl();
        List<PersonalFileEntity> personalFileEntityList = personalFileDao.order();
        return personalFileEntityList;
    }

    @Override
    public PersonalFileEntity personalFileSearch(String account) {
        PersonalFileDao personalFileDao = new PersonalFileDaoImpl();
        return personalFileDao.search(account) ;
    }

    @Override
    public int personalFileUpdate(String account, String gender, String phonenumber, String idnumber, String beginage, String email, String introduction) {
        PersonalFileDao personalFileDao = new PersonalFileDaoImpl();
        PersonalFileEntity personalFileEntity = personalFileDao.search(account);
        if (personalFileEntity == null) {
            System.out.println("没有此personal file entity ");
            return 0;
        } else {
            personalFileEntity.setGender(gender);
            personalFileEntity.setPhonenumber(phonenumber);
            personalFileEntity.setIdnumber(idnumber);
            personalFileEntity.setBeginage(beginage);
            personalFileEntity.setEmail(email);
            personalFileEntity.setIntroduction(introduction);
            personalFileDao.order();
            return personalFileDao.update(personalFileEntity);
        }
    }


    @Override
    public int personalFileDelete(String account) {
        PersonalFileDao personalFileDao = new PersonalFileDaoImpl();
        //默认账户存在 直接删除该账号(赋值为null)
        return personalFileDao.delete(account);
    }
}
