package fastcatch.api.db;


import fastcatch.api.core.User;
import fastcatch.api.core.mappers.UserMapper;
import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper;

// Dit is een voorbeeld
@RegisterMapper(UserMapper.class)
public interface UserDAO {

    @SqlUpdate("create table IF NOT EXISTS something (id int primary key, name varchar(100))")
    void createSomethingTable();

    @SqlUpdate("insert into something (id, name) values (:id, :name)")
    void insert(@Bind("id") int id, @Bind("name") String name);

    @SqlQuery("select id, name from something where id = :id")
    User findNameById(@Bind("id") int id);

}