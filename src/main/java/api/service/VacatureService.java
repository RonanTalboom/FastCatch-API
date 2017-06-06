package api.service;

import api.model.Vacature;
import api.persistence.VacatureDAO;

import java.util.Collection;

/**
 * Created by Anna on 30-5-2017.
 */
//@Singleton
public class VacatureService {
    private final VacatureDAO vacatureDAO;

    //@Inject
    public VacatureService(VacatureDAO vacatureDAO) { this.vacatureDAO = vacatureDAO; }

    public Collection<Vacature> getVacatures() { return vacatureDAO.getVacatures(); }

    public Vacature getVacature(int id) { return vacatureDAO.getVacature(id); }

    public Vacature getMeestBekekenVacature() { return vacatureDAO.getMeestBekekenVacature(); }
}
