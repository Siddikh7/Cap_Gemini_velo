package com.capgemini.polytech.service;

import com.capgemini.polytech.entity.Velo;
import com.capgemini.polytech.repository.VeloRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

/**
 * Service pour gérer les opérations liées aux vélos.
 */
@Service
public class VeloService {
    private final VeloRepository veloRepository;

    /**
     * Constructeur de la classe VeloService.
     *
     * @param veloRepository le repository pour les entités Velo
     */
    public VeloService(VeloRepository veloRepository) {
        this.veloRepository = veloRepository;
    }

    /**
     * Récupère tous les vélos.
     *
     * @return une liste de tous les vélos
     */
    public List<Velo> getAllVelos() {
        return veloRepository.findAll();
    }

    /**
     * Crée un nouveau vélo.
     *
     * @param velo le vélo à créer
     * @return le vélo créé
     */
    public Velo createVelo(Velo velo) {
        return veloRepository.save(velo);
    }

    /**
     * Trouve un vélo par son identifiant.
     *
     * @param id l'identifiant du vélo
     * @return le vélo trouvé
     * @throws NoSuchElementException si le vélo n'existe pas
     */
    public Velo findByIdVelo(int id) {
        Optional<Velo> velo = veloRepository.findById(id);
        return velo.orElseThrow(() -> new NoSuchElementException("Velo not found with id " + id));
    }

    /**
     * Met à jour un vélo existant.
     *
     * @param id l'identifiant du vélo à mettre à jour
     * @param velo les nouvelles informations du vélo
     * @return le vélo mis à jour
     * @throws NoSuchElementException si le vélo n'existe pas
     */
    public Velo updateVelo(int id, Velo velo) {
        Velo velo1 = veloRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("ce velo n'existe pas"));
        velo1.setNom(velo.getNom());
        velo1.setQuantite(velo.getQuantite());
        velo1.setDescription(velo.getDescription());
        velo1.setPointGeo(velo.getPointGeo());

        return veloRepository.save(velo1);
    }

    /**
     * Supprime un vélo par son identifiant.
     *
     * @param id l'identifiant du vélo à supprimer
     * @throws NoSuchElementException si le vélo n'existe pas
     */
    public void deleteVelo(int id) {
        if (!veloRepository.existsById(id)) {
            throw new NoSuchElementException("ce velo n'existe pas");
        }
        veloRepository.deleteById(id);
    }
}