package com.example.revision.controller;

import com.example.revision.entities.Assurance;
import com.example.revision.entities.Beneficiaire;
import com.example.revision.entities.Contrat;
import com.example.revision.entities.TypeContrat;
import com.example.revision.service.IExamenService;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
public class ExamenControoler {

    @Autowired
    IExamenService iExamenService;

    @GetMapping("/contrats")
    public List<Contrat> getAllContrats (){
        return  iExamenService.getAllContrats();
    }

    @GetMapping("/beneficiaires")
    public List<Beneficiaire> getAllBeneficiaires (){
        return  iExamenService.getAllBeneficiaires();
    }

    @GetMapping("/assurances")
    public List<Assurance> getAllAssurance (){
        return  iExamenService.getAllAssurance();
    }
    @PostMapping("/ajouterBeneficiaire")
    public Beneficiaire ajouterBeneficiaire (@RequestBody Beneficiaire bf){
        return  iExamenService.ajouterBeneficiaire(bf);
    }

    @PostMapping("/ajouterContrat")
    public Contrat ajouterContrat (@RequestBody Contrat c){
        return  iExamenService.ajouterContrat(c);
    }


    @PostMapping("/ajouterAssurance")
    public Assurance ajouterAssurance (@RequestBody Assurance a, @RequestBody int cinBf, @RequestBody String matricule){
        return  iExamenService.ajouterAssurance(a,cinBf,matricule);
    }

    @PostMapping("/getContratBf")
    public Contrat getContratBf ( @RequestParam("idBf")int idBf){
        return iExamenService.getContratBf(idBf) ;
    }

    @GetMapping("/getBeneficairesByType")
    public Set<Beneficiaire> getBeneficairesByType (@RequestParam("typeContrat") TypeContrat typeContrat){
        return  iExamenService.getBeneficairesByTypeV2(typeContrat);
    }

    @GetMapping("getMontantBf")
    public float getMontantBf (@RequestParam("cinBf") int cinBf){
        return  iExamenService.getMontantBf(cinBf);
    }
}
