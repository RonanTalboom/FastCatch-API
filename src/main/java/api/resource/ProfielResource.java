package api.resource;

import api.model.Profiel;
import api.service.ProfielService;

import java.util.Collection;

/**
 * Created by Anna on 31-5-2017.
 */
public class ProfielResource {
    private final ProfielService profielService;

    public ProfielResource(ProfielService profielService) { this.profielService = profielService; }

    public Collection<Profiel> retrieveAll() {
        Collection<Profiel> profielen = profielService.getProfielen();
        return profielen;
    }

    public Profiel get(int id) {
        Profiel profiel = profielService.getProfiel(id);
        return profiel;
    }
}
