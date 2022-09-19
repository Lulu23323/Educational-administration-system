import java.util.List;

public interface CollegeService {
    List<CollegeEntity> select();

    boolean collegeSearch(String id);

    int collegeUpdate(String id,String name, String intro);

    int collegeCreate(String id,String name, String intro);

    int collegeDelete(String id);

}
