package com.example.revision.service;


import com.example.revision.entities.Assurance;
import com.example.revision.entities.Beneficiaire;
import com.example.revision.entities.Contrat;
import com.example.revision.entities.TypeContrat;

import java.util.List;
import java.util.Set;

public interface IExamenService {


    Beneficiaire ajouterBeneficiaire(Beneficiaire bf);

    Contrat ajouterContrat(Contrat c);

    List<Beneficiaire> getAllBeneficiaires();

    List<Contrat> getAllContrats();

    Assurance ajouterAssurance(Assurance a, int cinBf, String matricule);

    List<Assurance> getAllAssurance();

    Contrat getContratBf(int idBf);

    Set<Beneficiaire> getBeneficairesByType(TypeContrat typeContrat);

    Set<Beneficiaire> getBeneficairesByTypeV2(TypeContrat typeContrat);

    float getMontantBf(int cinBf);
}
