package fastcatch.api.db;

import fastcatch.api.core.Gebruiker;
import fastcatch.api.core.mappers.GebruikerMapper;
import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper;

import java.util.List;

/**
 * Created by Anna on 12-6-2017.
 */
@RegisterMapper(GebruikerMapper.class)
public interface GebruikerDAO {

    @SqlQuery("select * from gebruiker_info")
    List<Gebruiker> getProfielen();

    @SqlQuery("select * from gebruiker_info where gebruikerID = :gebruikerID")
    Gebruiker getProfiel(@Bind("gebruikerID") int gebruikerID);

//    @SqlUpdate("update gebruiker_info set wachtwoord = :wachtwoord where emailAdres = :emailAdres")
//    void wijzigWachtwoord(@Bind("wachtwoord") String wachtwoord, @Bind("emailAdres") String emailAdres);
}
