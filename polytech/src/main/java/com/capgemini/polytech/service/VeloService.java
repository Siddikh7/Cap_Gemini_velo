package com.capgemini.polytech.service;

import com.capgemini.polytech.entity.Velo;
import com.capgemini.polytech.repository.VeloRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class VeloService {
    private final VeloRepository veloRepository;

    public VeloService(VeloRepository veloRepository){
        this.veloRepository = veloRepository;
    }
    public List<Velo> getAllVelos(){
        return veloRepository.findAll();
    }
    public Velo createVelo(Velo velo){
         return veloRepository.save(velo);
    }

    public Velo findByIdVelo(int id) {
        Optional<Velo> optionalVelo = veloRepository.findById(id);
        if (optionalVelo.isPresent()) {
            return optionalVelo.get();
        } else {
            throw new NoSuchElementException("ce velo n'existe pas");
        }
    }

    public Velo updateVelo(int id, Velo velo){
        Velo velo1 = veloRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("ce velo n'existe pas"));
        velo1.setNom(velo.getNom());
        velo1.setQuantite(velo.getQuantite());
        velo1.setDescription(velo.getDescription());
        velo1.setPointGeo(velo.getPointGeo());

        return veloRepository.save(velo1);
    }
    public void deleteVelo(int id){
        if(!veloRepository.existsById(id)){
            throw new NoSuchElementException("ce vel n'existe pas");
        }
        veloRepository.deleteById(id);
    }

}
