package fastcatch.api.core;

import java.util.List;
import java.util.Objects;

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

    @Override
    public boolean equals(Object obj) {

        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Expertise)) {
            return false;
        }
        return Objects.equals(((Expertise) obj).getExpertiseType(), this.getExpertiseType());

    }
}
