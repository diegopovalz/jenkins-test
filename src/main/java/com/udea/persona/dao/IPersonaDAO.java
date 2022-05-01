package com.udea.persona.dao;

import com.udea.persona.model.Persona;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPersonaDAO extends CrudRepository<Persona, Long> {
}
