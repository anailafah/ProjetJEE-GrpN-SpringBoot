package com.assurance.GestionAssuranceSpring.service;

import java.util.List;
import org.springframework.stereotype.Service;

import com.assurance.GestionAssuranceSpring.entity.Echeance;
import com.assurance.GestionAssuranceSpring.repository.EcheanceRepository;

@Service
public class EcheanceService {

    private final EcheanceRepository echeanceRepository;

    public EcheanceService(EcheanceRepository echeanceRepository) {
        this.echeanceRepository = echeanceRepository;
    }

    public List<Echeance> getAllEcheances() {
        return echeanceRepository.findAll();
    }

    public Echeance getEcheanceById(Long id) {
        return echeanceRepository.findById(id).orElse(null);
    }

    public Echeance saveEcheance(Echeance echeance) {
        return echeanceRepository.save(echeance);
    }

    public void deleteEcheance(Long id) {
        echeanceRepository.deleteById(id);
    }
}