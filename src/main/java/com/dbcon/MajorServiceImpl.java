package com.dbcon;
import java.util.List;

public class MajorServiceImpl implements MajorService{
    public MajorServiceImpl(){}

    @Override
    public List<MajorEntity> select() {
        MajorDao majorDao = new MajorDaoImpl();
        List<MajorEntity> majorEntityList = majorDao.select();
        return majorEntityList;
    }

    @Override
    public boolean majorSearch(String majorAccount) {
        MajorDao majorDao = new MajorDaoImpl();
        return majorDao.search(majorAccount) !=null;
    }

    @Override
    public int majorUpdate(String majorAccount, String major, String college, String majorIntro) {
        MajorDao majorDao = new MajorDaoImpl();
        MajorEntity majorEntity = majorDao.search(majorAccount);
        if(majorEntity == null){
            System.out.println("娌℃湁姝� major entity ");
            return 0;
        }else{
            majorEntity.setCollege(college);
            majorEntity.setMajor(major);
            majorEntity.setMajorIntro(majorIntro);
            return majorDao.update(majorEntity);
        }

    }

    @Override
    public int majorCreate(String majorAccount, String major, String college, String majorIntro) {
        MajorDao majorDao = new MajorDaoImpl();
        MajorEntity majorEntity = majorDao.addNewAccount(majorAccount);
        if(majorEntity == null){
            System.out.println("do not happen");
            return 0;
        }else{
            majorEntity.setMajorAccount(majorAccount);
            majorEntity.setCollege(college);
            majorEntity.setMajor(major);
            majorEntity.setMajorIntro(majorIntro);
            return majorDao.create(majorEntity);
        }
    }

    @Override
    public int majorDelete(String majorAccount) {
        MajorDao majorDao = new MajorDaoImpl();
        return majorDao.delete(majorAccount);
    }
}
