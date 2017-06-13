package fastcatch.api.core;

/**
 * Created by ronantalboom on 13/06/2017.
 */
public class Branche {
    private String brancheType;

    public Branche(String brancheType) {
        this.brancheType = brancheType;
    }

    public Branche() {
    }

    public String getBrancheType() {
        return brancheType;
    }

    public void setBrancheType(String BrancheType) {
        this.brancheType = brancheType;
    }
}
