package fastcatch.api.core;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * In deze klasse worden alle gegevens opgeslagen van een vacature.
 *
 * @author Luc
 */
public class Vacature implements Serializable {

    private int id;
    private String titel;
    private String rol;
    private String werkNiveau;
    private String eigenaar;
    private String klant;
    private String locatie;
    private Date startdatum;
    private Date einddatum;
    private Date publicatiedatum;
    private Date uitersteAanbiedingsdatum;
    private int uurPerWeek;
    private String aanvrager;
    private String omschrijving;
    private String samenvatting;
    private int actief;


    private String branchType;
    private List<Expertise> expertiseType;

    public Vacature(int id, String titel, String rol, String werkNiveau, String eigenaar, String klant, String locatie, Date startdatum, Date einddatum, Date publicatiedatum, Date uitersteAanbiedingsdatum, int uurPerWeek, String aanvrager, String omschrijving, String samenvatting, int actief) {
        this.id = id;
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

    public Vacature(int id, String titel, String rol, String werkNiveau, String eigenaar, String klant, String locatie, Date startdatum, Date einddatum, Date publicatiedatum, Date uitersteAanbiedingsdatum, int uurPerWeek, String aanvrager, String omschrijving, String samenvatting, int actief, String branchType, List<Expertise> expertiseType) {
        this.id = id;
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
        this.branchType = branchType;
        this.expertiseType = expertiseType;
    }

    public Vacature(String titel, String rol, String werkNiveau, String eigenaar, String klant, String locatie, Date startdatum, Date einddatum, Date publicatiedatum, Date uitersteAanbiedingsdatum, int uurPerWeek, String aanvrager, String omschrijving, String samenvatting, int actief, String branchType, List<Expertise> expertiseType) {
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
        this.branchType = branchType;
        this.expertiseType = expertiseType;
    }

    public Vacature(String titel, String rol, String werkNiveau, String eigenaar, String klant, String locatie, Date startdatum, Date einddatum, Date publicatiedatum, Date uitersteAanbiedingsdatum, int uurPerWeek, String aanvrager, String omschrijving, String samenvatting, int actief) {
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

    public List<Expertise> getExpertiseType() {
        return expertiseType;
    }

    public void setExpertiseType(List<Expertise> expertiseType) {
        this.expertiseType = expertiseType;
    }

    public Vacature() {

    }

    public String getBranchType() { return branchType; }
    public void setBranchType(String branchType) { this.branchType = branchType; }


    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

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

    public Date getStartdatum() { return startdatum; }
    public void setStartdatum(Date startdatum) { this.startdatum = startdatum; }

    public Date getEinddatum() { return einddatum; }
    public void setEinddatum(Date einddatum) { this.einddatum = einddatum; }

    public Date getPublicatiedatum() { return publicatiedatum; }
    public void setPublicatiedatum(Date publicatiedatum) { this.publicatiedatum = publicatiedatum; }

    public Date getUitersteAanbiedingsdatum() { return uitersteAanbiedingsdatum; }
    public void setUitersteAanbiedingsdatum(Date uitersteAanbiedingsdatum) { this.uitersteAanbiedingsdatum = uitersteAanbiedingsdatum; }

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