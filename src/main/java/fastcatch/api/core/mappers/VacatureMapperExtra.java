package fastcatch.api.core.mappers;

import fastcatch.api.core.Expertise;
import fastcatch.api.core.Vacature;
import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Deze klasse mapt alle info die uit de vacature database gehaald wordt naar een nieuw vacature object.
 *
 * @author Luc
 */
public class VacatureMapperExtra implements ResultSetMapper<Vacature> {

    /**
     * Mapt het meegegeven resultaat naar een nieuw vacature object en
     * returnt deze vacature.
     * @param index, r, ctx
     * @return Vacature
     * @throws SQLException
     */
    public Vacature map(int index, ResultSet r, StatementContext ctx) throws SQLException
    {
        return new Vacature(r.getInt("id"), r.getString("titel"), r.getString("rol"), r.getString("werkNiveau"),
                r.getString("eigenaar"), r.getString("klant"), r.getString("locatie"), r.getDate("startdatum"),
                r.getDate("einddatum"), r.getDate("publicatiedatum"), r.getDate("uitersteAanbiedingsdatum"),
                r.getInt("uurPerWeek"), r.getString("aanvrager"), r.getString("omschrijving"), r.getString("samenvatting"), r.getInt("actief"),
                r.getString("branchType"), (List<Expertise>) r.getArray("expertiseType"));
    }

}
