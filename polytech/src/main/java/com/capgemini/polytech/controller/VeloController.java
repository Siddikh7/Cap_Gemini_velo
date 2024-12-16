package com.capgemini.polytech.controller;

import com.capgemini.polytech.dto.VeloDTO;
import com.capgemini.polytech.entity.Velo;
import com.capgemini.polytech.mapper.VeloMapper;
import com.capgemini.polytech.service.VeloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/velos")
public class VeloController {
    private final VeloService veloService;
    private final VeloMapper veloMapper;


    @Autowired
    public VeloController(VeloService veloService, VeloMapper veloMapper){
        this.veloService = veloService;
        this.veloMapper = veloMapper;
    }


    @GetMapping
    @ResponseBody
    public ResponseEntity<List<VeloDTO>> getAllVel(){
        return ResponseEntity.ok(veloService.getAllVelos()
                .stream()
                .map(veloMapper::toDTO)
                .collect(Collectors.toList()));
    }

    @PostMapping()
    @ResponseBody
    public ResponseEntity<VeloDTO> createV(@RequestBody VeloDTO velodto){
        /*Velo velo = veloMapper.toEntity(velodto);
        Velo velo1 = veloService.createVelo(velo);
        VeloDTO veloDTO = veloMapper.toDTO(velo1);
        return ResponseEntity.ok(veloDTO);*/
        //version plus stylee
        return ResponseEntity.ok(
                veloMapper.toDTO(
                        veloService.createVelo(
                                veloMapper.toEntity(velodto))));
    }


    @GetMapping("/{id}")
    public ResponseEntity<Velo> getVeloById(@PathVariable int id) {
        Velo velo = veloService.findByIdVelo(id);
        if (velo != null) {
            return ResponseEntity.ok(velo);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping()
    public ResponseEntity<VeloDTO> MettreAJourVelo(@RequestParam int id, @RequestBody VeloDTO veloDTO) {
        try{
            return ResponseEntity.ok(
                    veloMapper.toDTO(
                            veloService.updateVelo(id, veloMapper.toEntity(veloDTO))));

        } catch (RuntimeException e) {
            throw new NoSuchElementException(e);
        }
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<String> supprimerVelo(@PathVariable  int id) {
        try {
            veloService.deleteVelo(id);
            return ResponseEntity.ok("velo bien supp");
        } catch (NoSuchElementException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("erreur : flm");
        }
    }
}