package com.assurance.GestionAssuranceSpring.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.assurance.GestionAssuranceSpring.entity.Contrat;
import com.assurance.GestionAssuranceSpring.repository.ContratRepository;

@Service
public class ContratService {

    private final ContratRepository contratRepository;

    public ContratService(ContratRepository contratRepository) {
        this.contratRepository = contratRepository;
    }

    public List<Contrat> getAllContrats() {
        return contratRepository.findAll();
    }

    public Contrat getContratById(Long id) {
        return contratRepository.findById(id).orElse(null);
    }

    public Contrat saveContrat(Contrat contrat) {
        return contratRepository.save(contrat);
    }

    public void deleteContrat(Long id) {
        contratRepository.deleteById(id);
    }
}