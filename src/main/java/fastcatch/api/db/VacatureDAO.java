package fastcatch.api.db;

import fastcatch.api.core.Vacature;
import fastcatch.api.core.mappers.VacatureMapper;
import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper;

import java.util.List;

/**
 * Created by Anna on 12-6-2017.
 */
@RegisterMapper(VacatureMapper.class)
public interface VacatureDAO {

    @SqlQuery("select * from vacature")
    List<Vacature> getVacatures();

    @SqlQuery("select * from vacature where id = :id")
    Vacature getVacature(@Bind("id") int id);
}
