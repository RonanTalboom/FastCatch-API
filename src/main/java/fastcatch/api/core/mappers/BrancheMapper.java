package fastcatch.api.core.mappers;

import fastcatch.api.core.Branche;
import fastcatch.api.core.Expertise;
import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Anna on 12-6-2017.
 */
public class BrancheMapper implements ResultSetMapper<Branche> {

    public Branche map(int index, ResultSet r, StatementContext ctx) throws SQLException {
        return new Branche(r.getString("brancheType"));
    }
}
