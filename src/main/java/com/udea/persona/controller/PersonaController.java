package com.udea.persona.controller;

import com.udea.persona.exception.ModelNotFoundException;
import com.udea.persona.model.Persona;
import com.udea.persona.service.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/persona")
@CrossOrigin("*")
public class PersonaController {

    // @Autowired
    private final PersonaService personaService;

    public PersonaController(final PersonaService personaService) {
        this.personaService = personaService;
    }

    @PostMapping("/save")
    public Long save(@RequestBody Persona p) {
        this.personaService.save(p);
        return p.getIdPerson();
    }

    @GetMapping("/listAll")
    public Iterable<Persona> listAll() {
        return this.personaService.list();
    }

    @GetMapping("/list/{id}")
    public Persona listById(@PathVariable Long id) {
        Optional<Persona> persona = this.personaService.listId(id);
        if(persona.isPresent()) {
            return persona.get();
        }
        throw new ModelNotFoundException("Id de persona inválido");
    }
}
