package fastcatch.api.core.mappers;

import fastcatch.api.core.Account;
import fastcatch.api.core.User;
import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import java.sql.ResultSet;
import java.sql.SQLException;


// Dit is een voorbeeld
public class UserMapper implements ResultSetMapper<User>
{
    public User map(int index, ResultSet r, StatementContext ctx) throws SQLException
    {
        return new User(r.getInt("id"), r.getString("name"));
    }
}