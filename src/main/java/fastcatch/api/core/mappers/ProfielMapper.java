package fastcatch.api.core.mappers;

import fastcatch.api.core.Profiel;
import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Anna on 12-6-2017.
 */
public class ProfielMapper implements ResultSetMapper<Profiel> {

    public Profiel map(int index, ResultSet r, StatementContext ctx) throws SQLException
    {
        return new Profiel(r.getString("emailAdres"), r.getString("geslacht"), r.getString("voornaam"),
                r.getString("tussenvoegsel"), r.getString("achternaam"), r.getString("soortGebruiker"),
                r.getString("telefoonNummer"), r.getString("cv"), r.getString("gebruikersnaam"),
                r.getString("wachtwoord"));
    }
}
