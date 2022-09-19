package com.dbcon;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GradeServiceImpl implements GradeService {
    public GradeServiceImpl(){}

    @Override
    public List<GradeEntity> select() {
        GradeDao gradeDao = new GradeDaoImpl();
        List<GradeEntity> gradeEntityList = gradeDao.select();
        return gradeEntityList;
    }

    @Override
    public List<GradeEntity> selectByCourseAccount(String courseAccount) {
        GradeDao gradeDao = new GradeDaoImpl();
        List<GradeEntity> gradeEntityList = gradeDao.selectCourseAccount(courseAccount);
        return gradeEntityList;
    }

    @Override
    public List<GradeEntity> selectByAccount(String Account) {
        GradeDao gradeDao = new GradeDaoImpl();
        List<GradeEntity> gradeEntityList = gradeDao.selectAccount(Account);
        return gradeEntityList;
    }

    @Override
    public List<GradeDetailEntity> getDetails(String courseAccount) {
        GradeDao gradeDao = new GradeDaoImpl();
        List<GradeDetailEntity> gradeEntityList = gradeDao.getDetails(courseAccount);
        return gradeEntityList;
    }

    @Override
    public List<GradeDetailEntity> getDetailsByStudent(String account) {
        GradeDao gradeDao = new GradeDaoImpl();
        List<GradeDetailEntity> gradeEntityList = gradeDao.getDetailsByStudent(account);
        return gradeEntityList;
    }


    @Override
    public GradeEntity gradeSearch(String courseAccount, String Account) {
        GradeDao gradeDao = new GradeDaoImpl();
        return gradeDao.search(courseAccount,Account);
    }

    @Override
    public int gradeUpdate(String courseAccount, String Account,String grade) {
       GradeDao gradeDao = new GradeDaoImpl();
        GradeEntity gradeEntity = gradeDao.search(courseAccount,Account);
        if(gradeEntity == null){
            System.out.println("there is no grade entity ");
            return 0;
        }else{
            gradeEntity.setGrade(grade);
            return gradeDao.update(gradeEntity);
        }
    }


    @Override
    public int gradeCreate(String courseAccount, String account, String college,String major, String grade) {
        GradeDao gradeDao = new GradeDaoImpl();
        GradeEntity gradeEntity = gradeDao.addNewAccount(courseAccount);
        if(gradeEntity == null){
            System.out.println("do not happen");
            return 0;
        }else{
            gradeEntity.setAccount(account);
            gradeEntity.setCollege(college);
            gradeEntity.setMajor(major);
            gradeEntity.setGrade(grade);
            return gradeDao.create(gradeEntity);
        }
    }
    @Override
    public int gradeDelete(String courseAccount, String Account) {
        GradeDao gradeDao = new GradeDaoImpl();
        return gradeDao.delete(courseAccount,Account);
    }
}
