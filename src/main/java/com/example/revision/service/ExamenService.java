package com.example.revision.service;

import com.example.revision.entities.Assurance;
import com.example.revision.entities.Beneficiaire;
import com.example.revision.entities.Contrat;
import com.example.revision.entities.TypeContrat;
import com.example.revision.repository.AssuranceRepository;
import com.example.revision.repository.BeneficiaireRepository;
import com.example.revision.repository.ContratRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ExamenService implements  IExamenService{

    @Autowired
    BeneficiaireRepository beneficiaireRepository;
     @Autowired
    ContratRepository contratRepository;
     @Autowired
    AssuranceRepository assuranceRepository;
    @Override
    public Beneficiaire ajouterBeneficiaire(Beneficiaire bf){
          return beneficiaireRepository.save(bf);
    }

    @Override
    public Contrat ajouterContrat(Contrat c) {
     return   contratRepository.save(c);
    }

    @Override
    public List<Beneficiaire> getAllBeneficiaires() {
        return beneficiaireRepository.findAll();
    }

    @Override
    public List<Contrat> getAllContrats() {
        return  contratRepository.findAll();
    }

    @Override
    public Assurance ajouterAssurance(Assurance a, int cinBf, String matricule) {
           Beneficiaire bf= beneficiaireRepository.findByCin(cinBf);
           Contrat contrat = contratRepository.findByMatricule(matricule);
           a.setBeneficiaire(bf);
           a.setContrat(contrat);
        return assuranceRepository.save(a);
    }

    @Override
    public List<Assurance> getAllAssurance() {
        return assuranceRepository.findAll();
    }

   /* @Override
    public Contrat getContratBf(int idBf) {
         Beneficiaire bf = beneficiaireRepository.findById(idBf);
         Contrat c =contratRepository.findAncienContrat(idBf);
        return  c;
    }*/
//v2
   @Override
   public Contrat getContratBf(int idBf) {
       Beneficiaire bf = beneficiaireRepository.findById(idBf);
       List<Assurance> assurances = assuranceRepository.findAssurancesByBeneficiaire(bf);
       Contrat ancienContrat = assurances.get(0).getContrat();
       for (int i = 0; i < assurances.size(); i++) {
           if (ancienContrat.getDateeffet().after(assurances.get(i).getContrat().getDateeffet()) ){
               ancienContrat=assurances.get(i).getContrat();
           }
       }
     return  ancienContrat;
   }

    @Override
    public Set<Beneficiaire> getBeneficairesByType(TypeContrat typeContrat) {
        //Lister tous les bénéficiaires selon un type de contrat donné.
        List<Assurance> assurances = assuranceRepository.findAll();
            Set <Beneficiaire> list=null;
        for (int i = 0; i < assurances.size(); i++) {
                if( ( assurances.get(i).getContrat().getType()==typeContrat ) ){
                list.add(assurances.get(i).getBeneficiaire());
            }
        }
        return list;
    }

    ///version 2

    @Override
    public Set<Beneficiaire> getBeneficairesByTypeV2(TypeContrat typeContrat) {
     return  beneficiaireRepository.getBeneficairesByType(typeContrat);
    }

    @Override
    public float getMontantBf(int cinBf) {
      /*
        Afficher le montant annuel des assurances par bénéficiaire
        N.B: Vous devez faire le calcul nécessaire pour les types de contact semestriel et
        mensuel : (semestriel x 2, mensuel x 12)
     */
       float montantAnnuel=0;

       List<Assurance> assurances = assuranceRepository.findAll();
        for (int i = 0; i < assurances.size(); i++) {
             if(assurances.get(i).getContrat().getType()== TypeContrat.Mensuel){
                 montantAnnuel+= assurances.get(i).getMontant()*12;
             } else if (assurances.get(i).getContrat().getType()==TypeContrat.Semestriel) {
                 montantAnnuel+= assurances.get(i).getMontant()*2;
             }else{
                 montantAnnuel+= assurances.get(i).getMontant();

             }
        }

       return montantAnnuel;
    }

    /*
       *  En utilisant SpringScheduler, proposer une méthode qui se déclenche toutes les 60
       *  secondes et qui affiche le nombre des assurances pour chaque bénéficiaire, ordonné par
       *  ordre décroissant, en respectant la signature suivante :
       * Vous pouvez utiliser une Map ordonnée (TreeMap<K, V>)
           *    K : nombre des assurances
           *    V : cin du bénéficiaire correspondant
    */

    @Scheduled(fixedRate = 60000)
    public void   AffichierNbAsutances(){

      Map<Integer , Integer > nbAssurancesParBeneficiaire = new TreeMap<>(Collections.reverseOrder());
      List<Assurance> assurances = assuranceRepository.findAll();

        for (int i = 0; i < assurances.size(); i++) {
           Beneficiaire b =assurances.get(i).getBeneficiaire();
                Integer nb=0;
                for (int j = 0; j < assurances.size(); j++) {
                   if (b.getIdBenef() == assurances.get(i).getBeneficiaire().getIdBenef()){
                       nb++;
                   }
                }
                nbAssurancesParBeneficiaire.put(nb,b.getCin());

        }
        for (Map.Entry<Integer, Integer> entry :
                nbAssurancesParBeneficiaire.entrySet()) {
            System.out.println("nb"+entry.getValue() +"cin : "+ entry.getValue());
        }

    }

}
