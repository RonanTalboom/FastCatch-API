package fastcatch.api.db;

import fastcatch.api.core.Branche;
import fastcatch.api.core.mappers.BrancheMapper;
import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.BindBean;
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

    @SqlUpdate("INSERT INTO gebruiker_branche (brancheType, gebruikerID) " +
            "VALUES (:brancheType, :gebruikerID)")
    void insertBrancheGebruiker(@BindBean Branche branche, @Bind("gebruikerID") int gebruikerID);

    @SqlQuery("SELECT brancheType FROM gebruiker_branche WHERE gebruikerID = :gebruikerID")
    List<Branche> getGebruikerBranches(@Bind("gebruikerID") int gebruikerID);

    @SqlUpdate("DELETE FROM gebruiker_branche WHERE gebruikerID = :gebruikerID AND brancheType = :brancheType")
    void deleteGebruikerBranche(@BindBean Branche branche, @Bind("gebruikerID") int gebruikerID);


}
