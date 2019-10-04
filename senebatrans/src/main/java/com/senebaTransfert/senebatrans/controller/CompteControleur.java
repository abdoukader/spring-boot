package com.senebaTransfert.senebatrans.controller;


import com.senebaTransfert.senebatrans.model.Compte;
import com.senebaTransfert.senebatrans.model.Partenaire;
import com.senebaTransfert.senebatrans.repository.CompteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@CrossOrigin

@RequestMapping(value = "/compte") // comme symfony Api/...
public class CompteControleur {

    @Autowired // sa permet de donner le reference de l'objet
    private CompteRepository compteRepository;

    @GetMapping(value = "/liste") // on peut faire un getMapping et lui passer tous notre url en parametre
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public List<Compte> list(){
        return  compteRepository.findAll();
    }

    @PostMapping(value = "/add",consumes = {MediaType.APPLICATION_JSON_VALUE})
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public Compte add(@RequestBody(required = false) Compte compte, Partenaire partenaire){
        int nombre =(int) (Math.random() *999999999)-100000000;
        nombre *= 9999999;
        compte.setNumerocompte(nombre);
        compte.setDatecreation(new Date());
        compte.setPartenaire();

        //partenaire.getUsers().get(0).setPartenaire(partenaire);
        return  compteRepository.save(compte); // on peut utiliser aussi saveOnUpdate   return "redirect:/user";
    }
}

