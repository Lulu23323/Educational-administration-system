import java.util.List;

public class CourseServiceImpl implements CourseService{
    CourseServiceImpl(){}

    @Override
    public List<CourseEntity> select() {
        CourseDaoImpl courseDao = new CourseDaoImpl();
        List<CourseEntity> courseEntityList = courseDao.select();
        return courseEntityList;
    }

    @Override
    //这个方法好像有点多余 但是也可以用
    public CourseEntity courseSearch(String courseAccount) {
        CourseDaoImpl courseDao = new CourseDaoImpl();
        return courseDao.search(courseAccount) ;
    }

    @Override
    public int courseUpdate(String courseAccount,String course,String college,String major, String intro) {
        CourseDao courseDao = new CourseDaoImpl();
        CourseEntity courseEntity = courseDao.search(courseAccount);
        if(courseEntity == null){
            System.out.println("there is no course entity ");
            return 0;
        }else{
            courseEntity.setCollege(college);
            courseEntity.setMajor(major);
            courseEntity.setCourse(course);
            courseEntity.setIntro(intro);
            return courseDao.update(courseEntity);
        }
    }

    @Override
    public int courseCreate(String courseAccount,String course,String college,String major, String intro) {
        CourseDao courseDao = new CourseDaoImpl();
        CourseEntity courseEntity = courseDao.addNewAccount(courseAccount);
        if(courseEntity == null){
            System.out.println("应该不会发生");
            return 0;
        }else{
            courseEntity.setCourseAccount(courseAccount);
            courseEntity.setCollege(college);
            courseEntity.setMajor(major);
            courseEntity.setCourse(course);
            courseEntity.setIntro(intro);
            return courseDao.create(courseEntity);
        }
    }

    @Override
    public int courseDelete(String courseAccount) {
        CourseDao courseDao = new CourseDaoImpl();
        return courseDao.delete(courseAccount);
    }

}
