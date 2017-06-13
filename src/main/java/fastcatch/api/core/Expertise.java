package fastcatch.api.core;

/**
 * Created by ronantalboom on 13/06/2017.
 */
public class Expertise {
    private String expertiseType;

    public Expertise(String expertiseType) {
        this.expertiseType = expertiseType;
    }

    public Expertise() {
    }

    public String getExpertiseType() {
        return expertiseType;
    }

    public void setExpertiseType(String expertiseType) {
        this.expertiseType = expertiseType;
    }
}
