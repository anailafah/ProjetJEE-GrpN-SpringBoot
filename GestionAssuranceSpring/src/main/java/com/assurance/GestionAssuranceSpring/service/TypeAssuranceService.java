package com.assurance.GestionAssuranceSpring.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.stereotype.Service;

import com.assurance.GestionAssuranceSpring.entity.TypeAssurance;
import com.assurance.GestionAssuranceSpring.repository.TypeAssuranceRepository;

@Service
public class TypeAssuranceService {

    private final TypeAssuranceRepository typeAssuranceRepository;

    // Injection du repository par Spring
    public TypeAssuranceService(TypeAssuranceRepository typeAssuranceRepository) {
        this.typeAssuranceRepository = typeAssuranceRepository;
    }

    public void ajouter(TypeAssurance type) {

        verifierTypeAssurance(type);

        type.setActif(true);

        typeAssuranceRepository.save(type);
    }

    public List<TypeAssurance> lister() {
        return typeAssuranceRepository.findAll();
    }

    public TypeAssurance trouverParId(Long id) {

        if (id == null || id <= 0) {
            throw new IllegalArgumentException("Identifiant invalide.");
        }

        return typeAssuranceRepository.findById(id).orElse(null);
    }

    public void modifier(TypeAssurance type) {

        if (type == null || type.getId() == null) {
            throw new IllegalArgumentException("Type d'assurance invalide.");
        }

        TypeAssurance existant = typeAssuranceRepository
                .findById(type.getId())
                .orElse(null);

        if (existant == null) {
            throw new IllegalArgumentException("Type d'assurance introuvable.");
        }

        verifierTypeAssurance(type);

        typeAssuranceRepository.save(type);
    }

    public void desactiver(Long id) {

        TypeAssurance type = trouverParId(id);

        if (type == null) {
            throw new IllegalArgumentException("Type d'assurance introuvable.");
        }

        type.setActif(false);

        typeAssuranceRepository.save(type);
    }

    private void verifierTypeAssurance(TypeAssurance type) {

        if (type == null) {
            throw new IllegalArgumentException("Type d'assurance obligatoire.");
        }

        if (type.getNom() == null || type.getNom().trim().isEmpty()) {
            throw new IllegalArgumentException("Le nom est obligatoire.");
        }

        // Vérification null-safe
        if (type.getDureeMois() == null || type.getDureeMois() <= 0) {
            throw new IllegalArgumentException(
                    "La durée doit être supérieure à zéro.");
        }

        BigDecimal tarif = type.getTarifBase();

        if (tarif == null || tarif.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException(
                    "Le tarif doit être supérieur à zéro.");
        }
    }
}