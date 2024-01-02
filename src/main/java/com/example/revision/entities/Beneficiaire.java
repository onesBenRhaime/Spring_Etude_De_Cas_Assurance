package com.example.revision.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.*;

import javax.swing.*;
import java.util.Set;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name ="beneficiare")
public class Beneficiaire {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idBenef ;

    @Column(name = "cin")
    private  Integer cin;

    @Column(name = "nom")
    private  String nom;

    @Column(name = "prenom")
    private  String prenom;

    @Column(name = "profession")
    private  String profession;

    @Column(name = "salaire")
    private  Float salaire;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "beneficiaire")
    @ToString.Exclude
    Set<Assurance> assurances;


}
