package fastcatch.api.core;

import java.io.Serializable;

/**
 * In deze klasse worden alle gegevens opgeslagen van een vacature.
 *
 * @author Anna
 */
public class Vacature implements Serializable {

    private int id;
    private String brancheType;
    private String titel;
    private String rol;
    private String werkNiveau;
    private String eigenaar;
    private String klant;
    private String locatie;
    private String startdatum;
    private String einddatum;
    private String publicatiedatum;
    private String uitersteAanbiedingsdatum;
    private int uurPerWeek;
    private String aanvrager;
    private String omschrijving;
    private String samenvatting;
    private int actief;

    public Vacature(int id, String brancheType, String titel, String rol, String werkNiveau, String eigenaar, String klant,
                    String locatie, String startdatum, String einddatum,
                    String publicatiedatum, String uitersteAanbiedingsdatum, int uurPerWeek,
                    String aanvrager, String omschrijving, String samenvatting, int actief) {
        this.id = id;
        this.brancheType = brancheType;
        this.titel = titel;
        this.rol = rol;
        this.werkNiveau = werkNiveau;
        this.eigenaar = eigenaar;
        this.klant = klant;
        this.locatie = locatie;
        this.startdatum = startdatum;
        this.einddatum = einddatum;
        this.publicatiedatum = publicatiedatum;
        this.uitersteAanbiedingsdatum = uitersteAanbiedingsdatum;
        this.uurPerWeek = uurPerWeek;
        this.aanvrager = aanvrager;
        this.omschrijving = omschrijving;
        this.samenvatting = samenvatting;
        this.actief = actief;
    }

    public Vacature() {

    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getBrancheType() { return brancheType; }
    public void setBrancheType(String brancheType) { this.brancheType = brancheType; }

    public String getTitel() { return titel; }
    public void setTitel(String titel) { this.titel = titel; }

    public String getRol() { return rol; }
    public void setRol(String rol) { this.rol = rol; }

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

    public int getUurPerWeek() { return uurPerWeek; }
    public void setUurPerWeek(int uurPerWeek) { this.uurPerWeek = uurPerWeek; }

    public String getAanvrager() { return aanvrager; }
    public void setAanvrager(String aanvrager) { this.aanvrager = aanvrager; }

    public String getOmschrijving() { return omschrijving; }
    public void setOmschrijving(String omschrijving) { this.omschrijving = omschrijving; }

    public String getSamenvatting() { return samenvatting; }
    public void setSamenvatting(String samenvatting) { this.samenvatting = samenvatting; }

    public int getActief() { return actief; }
    public void setActief(int actief) { this.actief = actief; }
}