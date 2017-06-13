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

    @SqlQuery("select * from vacature")
    List<Vacature> getVacatures();

    @SqlQuery("select * from vacature where id = :id")
    Vacature getVacature(@Bind("id") int id);

    @SqlUpdate("insert into vacature (BranchebrancheType, werkNiveau, eigenaar, klant, locatie, startdatum, einddatum, publicatiedatum, " +
            "uitersteAanbiedingsdatum, sluitDatum, uurPerWeek, aantalVacatures, aanvrager, omschrijving, samenvatting)" +
            "values (:BranchebrancheType, :werkNiveau, :eigenaar, :klant, :locatie, :startdatum, :einddatum, :publicatiedatum," +
            ":uitersteAanbiedingsdatum, :sluitDatum, :uurPerWeek, :aantalVacatures, :aanvrager, :omschrijving, :samenvatting)")
    void insert(@Bind("BranchebrancheType") String BranchebrancheType, @Bind("werkNiveau") String werkNiveau, @Bind("eigenaar") String eigenaar,
                @Bind("klant") String klant, @Bind("locatie") String locatie, @Bind("startdatum") String startdatum, @Bind("einddatum") String einddatum,
                @Bind("publicatiedatum") String publicatiedatum, @Bind("uitersteAanbiedingsdatum") String uitersteAanbiedingsdatum, @Bind("sluitDatum") String sluitDatum,
                @Bind("uurPerWeek") int uurPerWeek, @Bind("aantalVacatures") int aantalVacatures, @Bind("aanvrager") String aanvrager, @Bind("omschrijving") String omschrijving,
                @Bind("samenvatting") String samenvatting);
}
