package com.capgemini.polytech.controller;

import com.capgemini.polytech.dto.VeloDTO;
import com.capgemini.polytech.entity.Velo;
import com.capgemini.polytech.service.VeloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/velos")
public class VeloController {
    private final VeloService veloService;

    @Autowired
    public VeloController(VeloService veloService){
        this.veloService = veloService;
    }


    @GetMapping
    @ResponseBody
    public List<Velo> getAllVel(){
        return veloService.getAllVelos();
    }
    @PostMapping("/addvelo")
    @ResponseBody
    public void createV(@RequestBody Velo velo){
        veloService.createVelo(velo);
    }
//    @PostMapping
//    public Produit creerProduit(@RequestBody Produit produit) {
//        return produitService.creerProduit(produit);
//    }
//

//

    @GetMapping("/id")
    public ResponseEntity<Velo> trouverParIdVelo(@RequestParam int id) {
        Velo velo = veloService.findByIdVelo(id);
        if(velo == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        return ResponseEntity.ok(velo);
    }

    @PutMapping("/MAJid")
    public Velo MettreAJourVelo(@RequestParam int id, @RequestBody Velo velo) {
        try{

        } catch (RuntimeException e) {
            throw new NoSuchElementException(e);
        }
        return veloService.updateVelo(id, velo);
    }

    @DeleteMapping("/DELid")
    public ResponseEntity<String> supprimerVelo(@RequestParam  int id) {
        try {
            veloService.deleteVelo(id);
            return ResponseEntity.ok("velo bien supp");
        } catch (NoSuchElementException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("erreur : flm");
        }
    }
}
