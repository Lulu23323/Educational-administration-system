package com.dbcon;
import java.util.List;

public class StudentServiceImpl implements StudentService {
    public StudentServiceImpl() {
    }

    public List<StudentEntity> select() {
        StudentDao studentDao = new StudentDaoImpl();
        List<StudentEntity> studentEntityList = studentDao.select();
        return studentEntityList;
    }

    public List<StudentEntity> selectInOrder() {
        StudentDao studentDao = new StudentDaoImpl();
        List<StudentEntity> studentEntityList = studentDao.order();
        return studentEntityList;
    }

    @Override
    public boolean studentSearch(String account) {
        StudentDao studentDao = new StudentDaoImpl();
        return studentDao.search(account) !=null;
    }

    public int studentUpdate( String account, String fullName, String college, String major, String classNumber) {
		System.out.println("a"+account);
		System.out.println("b"+fullName);
		System.out.println("c "+college);
		System.out.println("d"+major);
		System.out.println("e"+classNumber);
    	StudentDao studentDao = new StudentDaoImpl();
        StudentEntity studentEntity = studentDao.search(account);
        if (studentEntity == null) {
            System.out.println("studentUpdate studentEntitynull ");
            return 0;
        } else {
            studentEntity.setFullName(fullName);
            studentEntity.setCollege(college);
            studentEntity.setMajor(major);
            studentEntity.setClassNumber(classNumber);
            studentDao.order();
            System.out.println("done");
            return studentDao.update(studentEntity);
        }
    }

    public int studentCreate(String account, String fullName, String college, String major, String classNumber) {

        StudentDaoImpl studentDao = new StudentDaoImpl();
        StudentEntity studentEntity = studentDao.addNewAccount(account);
        if (studentEntity == null) {
            System.out.println("studentEntity is null");
            return 0;
        } else {
            studentEntity.setFullName(fullName);
            studentEntity.setCollege(college);
            studentEntity.setMajor(major);
            studentEntity.setClassNumber(classNumber);
            System.out.println("classNumber");
//            studentDao.order();
            return studentDao.create(studentEntity);
        }
    }

    @Override
    public int studentDelete(String account) {
    	System.out.println("account"+account);
        StudentDao studentDao = new StudentDaoImpl();
        //榛樿璐︽埛瀛樺湪 鐩存帴鍒犻櫎璇ヨ处鍙�(璧嬪�间负null)
        System.out.println("done");
        return studentDao.delete(account);
    }
}
