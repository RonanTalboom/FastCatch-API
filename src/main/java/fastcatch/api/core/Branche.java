package fastcatch.api.core;

import java.util.Objects;

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

    @Override
    public boolean equals(Object obj) {

        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Branche)) {
            return false;
        }
        return Objects.equals(((Branche) obj).getBrancheType(), this.getBrancheType());

    }
}
