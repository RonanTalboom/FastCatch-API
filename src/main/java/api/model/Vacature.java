package api.model;

/**
 * Created by Anna on 30-5-2017.
 */
public class Vacature {

    //@NotEmpty
    //@JsonView(View.Public.class)
    private int id;

    //@NotEmpty
    //@JsonView(View.Public.class)
    private String brancheType;

    //@NotEmpty
    //@JsonView(View.Public.class)
    private String werkNiveau;

    //@NotEmpty
    //@JsonView(View.Public.class)
    private String eigenaar;

    //@NotEmpty
    //@JsonView(View.Public.class)
    private String klant;

    //@NotEmpty
    //@JsonView(View.Public.class)
    private String locatie;

    //@NotEmpty
    //@JsonView(View.Public.class)
    private String startdatum;

    //@NotEmpty
    //@JsonView(View.Public.class)
    private String einddatum;

    //@NotEmpty
    //@JsonView(View.Public.class)
    private String publicatiedatum;

    //@NotEmpty
    //@JsonView(View.Public.class)
    private String uitersteAanbiedingsdatum;

    //@NotEmpty
    //@JsonView(View.Public.class)
    private String sluitDatum;

    //@NotEmpty
    //@JsonView(View.Public.class)
    private int uurPerWeek;

    //@NotEmpty
    //@JsonView(View.Public.class)
    private int aantalVacatures;

    //@NotEmpty
    //@JsonView(View.Public.class)
    private String aanvrager;

    //@NotEmpty
    //@JsonView(View.Public.class)
    private String omschrijving;

    //@NotEmpty
    //@JsonView(View.Public.class)
    private String samenvatting;

    //@NotEmpty
    //@JsonView(View.Public.class)
    //private int aantalBekeken;

    public Vacature(int id, String brancheType, String werkNiveau, String eigenaar, String klant,
                    String locatie, String startdatum, String einddatum,
                    String publicatiedatum, String uitersteAanbiedingsdatum, String sluitDatum, int uurPerWeek,
                    int aantalVacatures, String aanvrager, String omschrijving, String samenvatting/*, int aantalBekeken*/) {
        this.id = id;
        this.brancheType = brancheType;
        this.werkNiveau = werkNiveau;
        this.eigenaar = eigenaar;
        this.klant = klant;
        this.locatie = locatie;
        this.startdatum = startdatum;
        this.einddatum = einddatum;
        this.publicatiedatum = publicatiedatum;
        this.uitersteAanbiedingsdatum = uitersteAanbiedingsdatum;
        this.sluitDatum = sluitDatum;
        this.uurPerWeek = uurPerWeek;
        this.aantalVacatures = aantalVacatures;
        this.aanvrager = aanvrager;
        this.omschrijving = omschrijving;
        this.samenvatting = samenvatting;
        //this.aantalBekeken = aantalBekeken;
    }

    public Vacature() {

    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getBrancheType() { return brancheType; }
    public void setBrancheType(String brancheType) { this.brancheType = brancheType; }

    public String getWerkNiveau() { return werkNiveau; }
    public void setWerkNiveau(String werkNiveau) { this.werkNiveau = werkNiveau; }

    public String getEigenaar() { return eigenaar; }
    public void setEigenaar(String eigenaar) { this.eigenaar = eigenaar; }

    public String getKlant() { return klant; }
    public void setKlant(String klant) { this.klant = klant; }

    public String getLocatie() { return locatie; }
    public void setLocatie(String locatie) { this.locatie = locatie; }

    public String getStartdatum() { return startdatum; }
    public void setStartdatum(String startdatum) { this.startdatum = startdatum; }

    public String getEinddatum() { return einddatum; }
    public void setEinddatum(String einddatum) { this.einddatum = einddatum; }

    public String getPublicatiedatum() { return publicatiedatum; }
    public void setPublicatiedatum(String publicatiedatum) { this.publicatiedatum = publicatiedatum; }

    public String getUitersteAanbiedingsdatum() { return uitersteAanbiedingsdatum; }
    public void setUitersteAanbiedingsdatum(String uitersteAanbiedingsdatum) { this.uitersteAanbiedingsdatum = uitersteAanbiedingsdatum; }

    public String getSluitDatum() { return sluitDatum; }
    public void setSluitDatum(String sluitDatum) { this.sluitDatum = sluitDatum; }

    public int getUurPerWeek() { return uurPerWeek; }
    public void setUurPerWeek(int uurPerWeek) { this.uurPerWeek = uurPerWeek; }

    public int getAantalVacatures() { return aantalVacatures; }
    public void setAantalVacatures(int aantalVacatures) { this.aantalVacatures = aantalVacatures; }

    public String getAanvrager() { return aanvrager; }
    public void setAanvrager(String aanvrager) { this.aanvrager = aanvrager; }

    public String getOmschrijving() { return omschrijving; }
    public void setOmschrijving(String omschrijving) { this.omschrijving = omschrijving; }

    public String getSamenvatting() { return samenvatting; }
    public void setSamenvatting(String samenvatting) { this.samenvatting = samenvatting; }

    /*public int getAantalBekeken() { return aantalBekeken; }
    public void setAantalBekeken(int aantalBekeken) { this.aantalBekeken = aantalBekeken; }*/
}
