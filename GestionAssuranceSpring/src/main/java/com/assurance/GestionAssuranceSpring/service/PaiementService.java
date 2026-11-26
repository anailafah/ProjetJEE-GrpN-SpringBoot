package com.assurance.GestionAssuranceSpring.service;

import java.util.List;
import org.springframework.stereotype.Service;

import com.assurance.GestionAssuranceSpring.entity.Paiement;
import com.assurance.GestionAssuranceSpring.repository.PaiementRepository;

@Service
public class PaiementService {

    private final PaiementRepository paiementRepository;

    public PaiementService(PaiementRepository paiementRepository) {
        this.paiementRepository = paiementRepository;
    }

    public List<Paiement> getAllPaiements() {
        return paiementRepository.findAll();
    }

    public Paiement getPaiementById(Long id) {
        return paiementRepository.findById(id).orElse(null);
    }

    public Paiement savePaiement(Paiement paiement) {
        return paiementRepository.save(paiement);
    }

    public void deletePaiement(Long id) {
        paiementRepository.deleteById(id);
    }
}