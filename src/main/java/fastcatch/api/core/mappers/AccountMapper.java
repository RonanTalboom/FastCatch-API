package fastcatch.api.core.mappers;

import fastcatch.api.core.Account;
import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
/**
 * Created by ronantalboom on 13/06/2017.
 */
public class AccountMapper implements ResultSetMapper<Account> {


    public Account map(int index, ResultSet r, StatementContext ctx) throws SQLException
    {
        return new Account(r.getInt("gebruikerID"),r.getString("emailAdres"), r.getString("wachtwoord"), r.getInt("actief"));
    }
}
