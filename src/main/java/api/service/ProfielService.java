package api.service;

import api.model.Profiel;
import api.persistence.ProfielDAO;

import java.util.Collection;

/**
 * Created by Anna on 31-5-2017.
 */
//@Singleton
public class ProfielService {
    private final ProfielDAO profielDAO;

    //@Inject
    public ProfielService(ProfielDAO profielDAO) { this.profielDAO = profielDAO; }

    public Collection<Profiel> getProfielen() { return profielDAO.getProfielen(); }

    public Profiel getProfiel(String emailAdres) { return profielDAO.getProfiel(emailAdres); }

    public void wijzigWachtwoord(Profiel profiel) { profielDAO.wijzigWachtwoord(profiel); }
}
