import java.util.List;

public interface CollegeDao {
    List<CollegeEntity> select();

    CollegeEntity search(String collegeAccount);

    CollegeEntity addNewAccount(String collegeAccount);

    int update(CollegeEntity collegeEntity);

    int create(CollegeEntity collegeEntity);

    int delete(String collegeAccount);
}
