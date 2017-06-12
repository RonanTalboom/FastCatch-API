package fastcatch.api.db;

import fastcatch.api.core.Profiel;
import fastcatch.api.core.mappers.ProfielMapper;
import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper;

import java.util.List;

/**
 * Created by Anna on 12-6-2017.
 */
@RegisterMapper(ProfielMapper.class)
public interface ProfielDAO {

    @SqlQuery("select * from gebruiker")
    List<Profiel> getProfielen();

    @SqlQuery("select * from gebruiker where emailAdres = :emailAdres")
    Profiel getProfiel(@Bind("emailAdres") String emailAdres);

    @SqlUpdate("update gebruiker set wachtwoord = :wachtwoord where emailAdres = :emailAdres")
    void wijzigWachtwoord(@Bind("wachtwoord") String wachtwoord, @Bind("emailAdres") String emailAdres);
}
