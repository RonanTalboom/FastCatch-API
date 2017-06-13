package fastcatch.api.db;

import fastcatch.api.core.Branche;
import fastcatch.api.core.Expertise;
import fastcatch.api.core.mappers.BrancheMapper;
import fastcatch.api.core.mappers.ExpertiseMapper;
import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper;

import java.util.List;

/**
 * Created by ronantalboom on 12-6-2017.
 */
@RegisterMapper(BrancheMapper.class)
public interface BrancheDAO {

    @SqlQuery("select * from branche")
    List<Branche> getBranches();

    @SqlUpdate("INSERT INTO gebruiker_branche (BranchebrancheType, gebruikerID)" +
            "VALUES (:branche, :gebruikerID)")
    void insertBrancheGebruiker(@Bind("branche") String branche, @Bind("gebruikerID") int gebruikerID);




}
