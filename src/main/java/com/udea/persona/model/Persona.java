package com.udea.persona.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Persona {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idPerson")
    private Long idPerson;

    @Column(name = "firstName", nullable = false, length = 80)
    @NonNull
    private String firstName;

    @Column(name = "lastName", nullable = false, length = 80)
    @NonNull
    private String lastName;

    @Column(name = "email", nullable = false, length = 80)
    @NonNull
    private String email;
}
