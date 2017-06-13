package fastcatch.api.core.mappers;

import fastcatch.api.core.Expertise;
import fastcatch.api.core.Vacature;
import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by ronantalboom on 12-6-2017.
 */
public class ExpertiseMapper implements ResultSetMapper<Expertise> {

    public Expertise map(int index, ResultSet r, StatementContext ctx) throws SQLException {
        return new Expertise(r.getString("expertiseType"));
    }
}
