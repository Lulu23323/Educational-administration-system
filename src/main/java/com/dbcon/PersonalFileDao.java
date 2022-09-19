package com.dbcon;
import java.util.List;
public interface PersonalFileDao {
    List<PersonalFileEntity> getPersonalFileEntities(String sql);

    List<PersonalFileEntity> select();

    List<PersonalFileEntity> order();

    PersonalFileEntity search(String var1);

    PersonalFileEntity addNewAccount(String account);

    int update(PersonalFileEntity var2);

    int create(PersonalFileEntity var2);

    int delete(String account);

}
