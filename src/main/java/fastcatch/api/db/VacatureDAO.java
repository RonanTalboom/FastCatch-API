package fastcatch.api.db;

import fastcatch.api.core.Vacature;
import fastcatch.api.core.mappers.VacatureMapper;
import org.skife.jdbi.v2.sqlobject.Bind;
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

    @SqlQuery("select * from vacature where id = :id and actief = 1")
    Vacature getVacature(@Bind("id") int id);

    @SqlUpdate("insert into vacature (BranchebrancheType, titel, rol, werkNiveau, eigenaar, klant, locatie, startdatum, einddatum, publicatiedatum, " +
            "uitersteAanbiedingsdatum, uurPerWeek, aanvrager, omschrijving, samenvatting, actief)" +
            "values (:BranchebrancheType, :titel, :rol, :werkNiveau, :eigenaar, :klant, :locatie, :startdatum, :einddatum, :publicatiedatum," +
            ":uitersteAanbiedingsdatum, :uurPerWeek, :aanvrager, :omschrijving, :samenvatting, :actief)")
    void insert(@Bind("BranchebrancheType") String BranchebrancheType, @Bind("titel") String titel, @Bind("rol") String rol, @Bind("werkNiveau") String werkNiveau, @Bind("eigenaar") String eigenaar,
                @Bind("klant") String klant, @Bind("locatie") String locatie, @Bind("startdatum") String startdatum, @Bind("einddatum") String einddatum,
                @Bind("publicatiedatum") String publicatiedatum, @Bind("uitersteAanbiedingsdatum") String uitersteAanbiedingsdatum,
                @Bind("uurPerWeek") int uurPerWeek, @Bind("aanvrager") String aanvrager, @Bind("omschrijving") String omschrijving,
                @Bind("samenvatting") String samenvatting, @Bind("actief") int actief);

    @SqlUpdate("update vacature set actief = 0 where id = :id")
    void delete(@Bind("id") int id);
}
