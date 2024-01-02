package com.example.revision.repository;

import com.example.revision.entities.Assurance;
import com.example.revision.entities.Beneficiaire;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AssuranceRepository  extends JpaRepository<Assurance,Integer> {
    List<Assurance>  findAssurancesByBeneficiaire (Beneficiaire bf);

}
