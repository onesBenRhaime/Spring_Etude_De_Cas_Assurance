package com.example.revision.repository;

import com.example.revision.entities.Beneficiaire;
import com.example.revision.entities.TypeContrat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Set;

public interface BeneficiaireRepository  extends JpaRepository<Beneficiaire , Integer> {
    Beneficiaire findByCin(int cin );
    Beneficiaire findById(int id );

    @Query("select b FROM  Beneficiaire  b join  b.assurances a join a.contrat c where  c.type= :tc")
    Set<Beneficiaire> getBeneficairesByType (@Param("tc")TypeContrat tc);
}
