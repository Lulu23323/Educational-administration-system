
import java.util.List;

public class CollegeServiceImpl implements CollegeService{
    CollegeServiceImpl(){}

    @Override
    public List<CollegeEntity> select() {
        CollegeDao collegeDao = new CollegeDaoImpl();
        List<CollegeEntity> collegeEntityList = collegeDao.select();
        return collegeEntityList;
    }

    @Override
    public boolean collegeSearch(String collegeAccount) {
        CollegeDao collegeDao = new CollegeDaoImpl();
        return collegeDao.search(collegeAccount) !=null;
    }

    @Override
    public int collegeUpdate(String collegeAccount, String college, String collegeIntro) {
        CollegeDao collegeDao = new CollegeDaoImpl();
        CollegeEntity collegeEntity = collegeDao.search(collegeAccount);
        if(collegeEntity == null){
            System.out.println("there is no college entity ");
            return 0;
        }else{
            collegeEntity.setCollege(college);
            collegeEntity.setCollegeIntro(collegeIntro);
            return collegeDao.update(collegeEntity);
        }

    }

    @Override
    public int collegeCreate(String collegeAccount, String college, String collegeIntro) {
        CollegeDao collegeDao = new CollegeDaoImpl();
        CollegeEntity collegeEntity = collegeDao.addNewAccount(collegeAccount);
        if(collegeEntity == null){
            System.out.println("do not happen");
            return 0;
        }else{
            collegeEntity.setCollegeAccount(collegeAccount);
            collegeEntity.setCollege(college);
            collegeEntity.setCollegeIntro(collegeIntro);
            return collegeDao.create(collegeEntity);
        }
    }

    @Override
    public int collegeDelete(String collegeAccount) {
        CollegeDao collegeDao = new CollegeDaoImpl();
        return collegeDao.delete(collegeAccount);
    }

}
