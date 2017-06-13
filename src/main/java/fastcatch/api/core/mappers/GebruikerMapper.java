package fastcatch.api.core.mappers;

import fastcatch.api.core.Gebruiker;
import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Anna on 12-6-2017.
 */
public class GebruikerMapper implements ResultSetMapper<Gebruiker> {

    public Gebruiker map(int index, ResultSet r, StatementContext ctx) throws SQLException
    {
        return new Gebruiker(r.getInt("gebruikerID"), r.getString("geslacht"), r.getString("voornaam"),
                r.getString("tussenvoegsel"), r.getString("achternaam"), r.getString("soortGebruiker"),
                r.getString("telefoonNummer"), r.getString("cv"), r.getString("gebruikersnaam")
                );
    }
}
