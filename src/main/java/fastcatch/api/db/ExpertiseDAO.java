package fastcatch.api.db;

import fastcatch.api.core.Expertise;
import fastcatch.api.core.Gebruiker;
import fastcatch.api.core.mappers.ExpertiseMapper;
import fastcatch.api.core.mappers.GebruikerMapper;
import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper;

import java.util.List;

/**
 * Created by ronantalboom on 12-6-2017.
 */
@RegisterMapper(ExpertiseMapper.class)
public interface ExpertiseDAO {

    @SqlQuery("select * from expertise")
    List<Expertise> getExpertises();

}
