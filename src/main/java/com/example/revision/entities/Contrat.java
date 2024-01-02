package com.example.revision.entities;

import jakarta.persistence.*;
import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "contrat")
public class Contrat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idContrat;

    @Column(name = "matricule")
    private  String matricule;

    @Column(name = "dateeffet")
    private Date dateeffet;
    @Column(name = "type")
    @Enumerated(EnumType.STRING)
    TypeContrat type;



}
