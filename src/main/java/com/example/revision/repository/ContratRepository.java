


package com.example.revision.repository;

import com.example.revision.entities.Beneficiaire;
import com.example.revision.entities.Contrat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ContratRepository extends JpaRepository<Contrat, Integer> {
    Contrat findByMatricule(String matricule);
    @Query("SELECT c FROM Contrat  c join  Assurance a  ON a.beneficiaire=: idBf  ORDER BY c.dateeffet ASC")
    Contrat findAncienContrat(@Param("idBf") int idBf);
}

