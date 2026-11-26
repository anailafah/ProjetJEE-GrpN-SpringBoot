package com.assurance.GestionAssuranceSpring.service;

import java.util.List;
import org.springframework.stereotype.Service;

import com.assurance.GestionAssuranceSpring.entity.Sinistre;
import com.assurance.GestionAssuranceSpring.repository.SinistreRepository;

@Service
public class SinistreService {

    private final SinistreRepository sinistreRepository;

    public SinistreService(SinistreRepository sinistreRepository) {
        this.sinistreRepository = sinistreRepository;
    }

    public List<Sinistre> getAllSinistres() {
        return sinistreRepository.findAll();
    }

    public Sinistre getSinistreById(Long id) {
        return sinistreRepository.findById(id).orElse(null);
    }

    public Sinistre saveSinistre(Sinistre sinistre) {
        return sinistreRepository.save(sinistre);
    }

    public void deleteSinistre(Long id) {
        sinistreRepository.deleteById(id);
    }
}