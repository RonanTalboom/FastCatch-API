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
    private String titel;

    //@NotEmpty
    //@JsonView(View.Public.class)
    private double aantalUur;

    //@NotEmpty
    //@JsonView(View.Public.class)
    private double uurloon;

    //@NotEmpty
    //@JsonView(View.Public.class)
    private String plaats;

    //@NotEmpty
    //@JsonView(View.Public.class)
    private String branche;

    //@NotEmpty
    //@JsonView(View.Public.class)
    private String organisatie;

    //@NotEmpty
    //@JsonView(View.Public.class)
    private String korteSamenvatting;

    //@NotEmpty
    //@JsonView(View.Public.class)
    private String volledigeSamenvatting;

    //@NotEmpty
    //@JsonView(View.Public.class)
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
