package api.model;

/**
 * Created by Anna on 30-5-2017.
 */
public class Vacature {

    private int id;

    private String titel;

    private double aantalUur;

    private double uurloon;

    private String plaats;

    private String branche;

    private String organisatie;

    private String korteSamenvatting;

    private String volledigeSamenvatting;

    private int aantalBekeken;

    public Vacature(int id, String titel, double aantalUur, double uurloon, String plaats,
                    String branche, String organisatie, String korteSamenvatting,
                    String volledigeSamenvatting, int aantalBekeken) {
        this.id = id;
        this.titel = titel;
        this.aantalUur = aantalUur;
        this.uurloon = uurloon;
        this.plaats = plaats;
        this.branche = branche;
        this.organisatie = organisatie;
        this.korteSamenvatting = korteSamenvatting;
        this.volledigeSamenvatting = volledigeSamenvatting;
        this.aantalBekeken = aantalBekeken;
    }

    public Vacature() {

    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getTitel() { return titel; }
    public void setTitel(String titel) { this.titel = titel; }

    public double getAantalUur() { return aantalUur; }
    public void setAantalUur(double aantalUur) { this.aantalUur = aantalUur; }

    public double getUurloon() { return uurloon; }
    public void setUurloon(double uurloon) { this.uurloon = uurloon; }

    public String getPlaats() { return plaats; }
    public void setPlaats(String plaats) { this.plaats = plaats; }

    public String getBranche() { return branche; }
    public void setBranche(String branche) { this.branche = branche; }

    public String getOrganisatie() { return organisatie; }
    public void setOrganisatie(String organisatie) { this.organisatie = organisatie; }

    public String getKorteSamenvatting() { return korteSamenvatting; }
    public void setKorteSamenvatting(String korteSamenvatting) { this.korteSamenvatting = korteSamenvatting; }

    public String getVolledigeSamenvatting() { return volledigeSamenvatting; }
    public void setVolledigeSamenvatting(String volledigeSamenvatting) { this.volledigeSamenvatting = volledigeSamenvatting; }

    public int getAantalBekeken() { return aantalBekeken; }
    public void setAantalBekeken(int aantalBekeken) { this.aantalBekeken = aantalBekeken; }
}
