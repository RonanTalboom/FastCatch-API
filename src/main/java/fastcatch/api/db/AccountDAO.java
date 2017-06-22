package fastcatch.api.db;

import fastcatch.api.core.Account;
import fastcatch.api.core.mappers.AccountMapper;
import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper;

/**
 * Created by ronantalboom on 12/06/2017.
 */
@RegisterMapper(AccountMapper.class)
public interface AccountDAO {


    @SqlQuery("select * from account where emailAdres = :emailAdres AND wachtwoord = :wachtwoord")
    Account getAccount( @Bind("emailAdres") String emailAdres, @Bind("wachtwoord") String wachtwoord);

    @SqlUpdate("update account set actief = 0 where gebruikerID = :id")
    void delete(@Bind("id") int id);

}
