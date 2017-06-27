package fastcatch.api.db;

import fastcatch.api.core.Vacature;
import fastcatch.api.core.mappers.VacatureMapper;
import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.BindBean;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper;

import java.util.List;

/**
 * Deze klasse maakt door middel van queries verbinding met de vacature tabel
 * in de database.
 *
 * @author Anna
 */
@RegisterMapper(VacatureMapper.class)
public interface VacatureDAO {

    /**
     * Haalt alle vacatures uit de database op die actief zijn.
     * @return vacaturelijst
     */
    @SqlQuery("select * from vacature where actief = 1")
    List<Vacature> getVacatures();

    /**
     * Haalt alle vacatures uit de database op die niet actief zijn.
     * @return vacaturelijst
     */
    @SqlQuery("select * from vacature where actief = 0")
    List<Vacature> getArchiefVacatures();

    /**
     * Haalt alle vacatures uit de database op die interessant voor de
     * huidige gebruiker zijn en actief zijn.
     * @param gebruikerID
     * @return vacaturelijst
     */
    @SqlQuery("select vacature.* from vacature " +
            "INNER JOIN gebruiker_branche g ON vacature.BranchebrancheType = g.BranchebrancheType " +
            "INNER JOIN gebruiker_expertise ON g.gebruikerID = gebruiker_expertise.gebruikerID " +
            "INNER JOIN expertise_vacature ON vacature.id = expertise_vacature.Vacatureid " +
            "WHERE g.gebruikerID = :gebruikerID and gebruiker_expertise.ExpertiseexpertiseType = expertise_vacature.ExpertiseexpertiseType " +
            "and actief = 1")
    List<Vacature> getVacaturesVoorGebruiker(@Bind("gebruikerID") int gebruikerID);

    /**
     * Haalt de vacature op die een id heeft die overeenkomt met de meegegeven
     * id en actief is.
     * @param id
     * @return vacature
     */
    @SqlQuery("select * from vacature where id = :id and actief = 1")
    Vacature getVacature(@Bind("id") int id);

    /**
     * Voegt een nieuwe vacature toe in de tabel.
     * @param vacature
     */
    @SqlUpdate("insert into vacature (titel, rol, werkNiveau, eigenaar, klant, locatie, startdatum, einddatum, publicatiedatum, " +
            "uitersteAanbiedingsdatum, uurPerWeek, aanvrager, omschrijving, samenvatting, actief)" +
            "values (:titel, :rol, :werkNiveau, :eigenaar, :klant, :locatie, :startdatum, :einddatum, :publicatiedatum," +
            ":uitersteAanbiedingsdatum, :uurPerWeek, :aanvrager, :omschrijving, :samenvatting, :actief)")
    void insert(@BindBean Vacature vacature);

    /**
     * Zet de vacature met de id die overeenkomt met de meegegeven
     * id op non-actief.
     * @param id
     */
    @SqlUpdate("update vacature set actief = 0 where id = :id")
    void archiveer(@Bind("id") int id);

    /**
     * Zet de vacature met de id die overeenkomt met de meegegeven
     * id op non-actief.
     * @param id
     */
    @SqlUpdate("delete from vacature where id = :id")
    void delete(@Bind("id") int id);

    /**
     * Zet de vacature met de id die overeenkomt met de meegegeven
     * id op actief.
     * @param id
     */
    @SqlUpdate("update vacature set actief = 1 where id = :id")
    void activate(@Bind("id") int id);

    @SqlQuery("select vacature.* from vacature,branche_vacature," +
            "gebruiker_branche,gebruiker_expertise,expertise_vacature " +
            "WHERE gebruiker_branche.brancheType = branche_vacature.branchType " +
            "AND gebruiker_expertise.expertiseType = expertise_vacature.expertiseType " +
            "AND gebruiker_branche.gebruikerID = gebruiker_expertise.gebruikerID " +
            "AND expertise_vacature.vacatureid = vacature.id " +
            "AND branche_vacature.vacatureId = vacature.id " +
            "AND gebruiker_branche.gebruikerID = 1 " +
            "AND vacature.actief = 1")
    List<Vacature> getVacaturesGebruiker(@Bind("gebruikerID") int gebruikerID);

}
