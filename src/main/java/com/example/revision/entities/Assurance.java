package com.example.revision.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "assurance")
public class Assurance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Integer idAssurance;

    @Column(name = "designation")
    private  String  designation;

    @Column(name = "montant")
    private  Float montant;

    @ManyToOne
    @JsonIgnore
    @ToString.Exclude
    Beneficiaire beneficiaire;

    @ManyToOne
    @JsonIgnore
    @ToString.Exclude
    Contrat contrat;

}
