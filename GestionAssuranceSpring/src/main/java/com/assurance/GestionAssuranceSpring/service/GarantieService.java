package com.assurance.GestionAssuranceSpring.service;

import java.util.List;
import org.springframework.stereotype.Service;

import com.assurance.GestionAssuranceSpring.entity.Garantie;
import com.assurance.GestionAssuranceSpring.repository.GarantieRepository;

@Service
public class GarantieService {

    private final GarantieRepository garantieRepository;

    public GarantieService(GarantieRepository garantieRepository) {
        this.garantieRepository = garantieRepository;
    }

    public List<Garantie> getAllGaranties() {
        return garantieRepository.findAll();
    }

    public Garantie getGarantieById(Long id) {
        return garantieRepository.findById(id).orElse(null);
    }

    public Garantie saveGarantie(Garantie garantie) {
        return garantieRepository.save(garantie);
    }

    public void deleteGarantie(Long id) {
        garantieRepository.deleteById(id);
    }
}