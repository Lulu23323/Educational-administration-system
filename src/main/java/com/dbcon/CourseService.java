import java.util.List;

public interface CourseService {
    List<CourseEntity> select();

    CourseEntity courseSearch(String id);

    int courseUpdate(String id,String name,String college,String major, String intro);

    int courseCreate(String id,String name,String college,String major, String intro);

    int courseDelete(String id);

}
