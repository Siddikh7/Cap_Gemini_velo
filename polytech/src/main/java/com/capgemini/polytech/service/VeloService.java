package com.capgemini.polytech.service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.capgemini.polytech.dto.VeloDTO;
import com.capgemini.polytech.entity.Velo;
import com.capgemini.polytech.mapper.VeloMapper;
import com.capgemini.polytech.repository.VeloRepository;

@Service
public class VeloService {
    private final VeloRepository veloRepository;
    private final VeloMapper veloMapper ;

    public VeloService(VeloRepository veloRepository, VeloMapper veloMapper){
        this.veloRepository = veloRepository;
        this.veloMapper = veloMapper;
    }
    public List<Velo> getAllVelos(){
        return veloRepository.findAll();
    }
    public void createVelo(Velo velo){
        veloRepository.save(velo);
    }

    public void createVelo(VeloDTO veloDTO){
        Velo velo = veloMapper.toEntity(veloDTO);
        veloRepository.save(velo);
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
        Optional<Velo> optionalVelo = veloRepository.findById(id);
        if(optionalVelo.isPresent()){
            Velo velo1 = optionalVelo.get();
            velo1.setNom(velo.getNom());
            velo1.setDescription(velo.getDescription());
            velo1.setQuantite(velo.getQuantite());
            velo1.setPointGeo(velo.getPointGeo());
            return veloRepository.save(velo1);
        }else{
            throw new NoSuchElementException("ce velo existe pas");
        }
    }
    public void deleteVelo(int id){
        if(!veloRepository.existsById(id)){
            throw new NoSuchElementException("ce vel n'existe pas");
        }
        veloRepository.deleteById(id);
    }

}
