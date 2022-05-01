package com.udea.persona.service;

import com.udea.persona.dao.IPersonaDAO;
import com.udea.persona.model.Persona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Optional;

@Service
public class PersonaService {
    // @Autowired ?
    private final IPersonaDAO personaDAO;

    @PersistenceContext
    private EntityManager entityManager;

    public PersonaService(final IPersonaDAO personaDAO) {
        this.personaDAO = personaDAO;
    }

    public Persona save(Persona p) {
        return this.personaDAO.save(p);
    }

    public Persona update(Persona p) {
        return this.personaDAO.save(p);
    }

    public void delete(Persona p) {
        this.personaDAO.delete(p);
    }

    /*public Iterable<Persona> list() {
        return this.personaDAO.findAll();
    }¨*/

    public List<Persona> list() {
        return this.entityManager.createNativeQuery("SELECT * FROM persona").getResultList();
    }

    public Optional<Persona> listId(Long id) {
        return this.personaDAO.findById(id);
    }
}
