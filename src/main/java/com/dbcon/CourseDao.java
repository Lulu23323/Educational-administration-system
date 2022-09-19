import java.util.List;

public interface CourseDao {
    List<CourseEntity> select();

    CourseEntity search(String courseAccount);

    CourseEntity addNewAccount(String courseAccount);

    int update(CourseEntity courseEntity);

    int create(CourseEntity courseEntity);

    int delete(String courseAccount);


}
