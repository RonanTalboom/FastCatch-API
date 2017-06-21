package fastcatch.api.core.mappers;

import fastcatch.api.core.Vacature;
import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Anna on 12-6-2017.
 */
public class VacatureMapper implements ResultSetMapper<Vacature> {

    public Vacature map(int index, ResultSet r, StatementContext ctx) throws SQLException {
        return new Vacature(r.getString("titel"), r.getString("rol"), r.getString("werkNiveau"),
                r.getString("eigenaar"), r.getString("klant"), r.getString("locatie"), r.getDate("startdatum"),
                r.getDate("einddatum"), r.getDate("publicatiedatum"), r.getDate("uitersteAanbiedingsdatum"),
                r.getInt("uurPerWeek"), r.getString("aanvrager"), r.getString("omschrijving"), r.getString("samenvatting"), r.getInt("actief"));
    }


}
