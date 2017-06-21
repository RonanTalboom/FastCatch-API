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
 * Created by Anna on 12-6-2017.
 */
@RegisterMapper(VacatureMapper.class)
public interface VacatureDAO {

    @SqlQuery("select * from vacature where actief = 1")
    List<Vacature> getVacatures();

    @SqlQuery("select vacature.* from vacature " +
            "INNER JOIN gebruiker_branche ON vacature.BranchebrancheType = gebruiker_branche.BranchebrancheType " +
            "WHERE actief = 1 AND gebruiker_branche.gebruikerID = :gebruikerID " +
            "order by vacature.id")
    List<Vacature> getVacaturesVoorGebruiker(@Bind("gebruikerID") int gebruikerID);

    @SqlQuery("select * from vacature where id = :id and actief = 1")
    Vacature getVacature(@Bind("id") int id);

    @SqlUpdate("insert into vacature (BranchebrancheType, titel, rol, werkNiveau, eigenaar, klant, locatie, startdatum, einddatum, publicatiedatum, " +
            "uitersteAanbiedingsdatum, uurPerWeek, aanvrager, omschrijving, samenvatting, actief)" +
            "values (:brancheType, :titel, :rol, :werkNiveau, :eigenaar, :klant, :locatie, :startdatum, :einddatum, :publicatiedatum," +
            ":uitersteAanbiedingsdatum, :uurPerWeek, :aanvrager, :omschrijving, :samenvatting, :actief)")
    void insert(@BindBean Vacature vacature);

    @SqlUpdate("update vacature set actief = 0 where id = :id")
    void delete(@Bind("id") int id);
}
