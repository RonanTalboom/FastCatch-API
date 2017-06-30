package fastcatch.api.db;

import fastcatch.api.core.Expertise;
import fastcatch.api.core.mappers.ExpertiseMapper;
import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.BindBean;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper;

import java.util.List;

/**
 * Created by ronantalboom on 12-6-2017.
 */
@RegisterMapper(ExpertiseMapper.class)
public interface ExpertiseDAO {

    @SqlQuery("select * from expertise")
    List<Expertise> getExpertises();

    @SqlUpdate("INSERT INTO gebruiker_expertise (expertiseType, gebruikerID)" +
            "VALUES (:expertiseType, :gebruikerID)")
    void insertExpertiseGebruiker(@BindBean Expertise expertise, @Bind("gebruikerID") int gebruikerID);

    @SqlUpdate("INSERT INTO expertise_vacature (expertiseType, vacatureID)" +
            "VALUES (:expertiseType, :vacatureID)")
    void insertExpertiseVacature(@BindBean Expertise expertise, @Bind("vacatureID") int vacatureID);

    @SqlQuery("SELECT expertiseType FROM gebruiker_expertise WHERE gebruikerID = :gebruikerID")
    List<Expertise> getGebruikerExpertises(@Bind("gebruikerID") int gebruikerID);

    @SqlUpdate("DELETE FROM gebruiker_expertise WHERE gebruikerID = :gebruikerID AND expertiseType = :expertiseType")
    void deleteGebruikerExpertise(@BindBean Expertise expertise, @Bind("gebruikerID") int gebruikerID);

    @SqlQuery("SELECT expertiseType FROM expertise_vacature WHERE vacatureid = :vacatureID")
    List<Expertise> getVacatureExpertises(@Bind("vacatureID") int vacatureID);
}
