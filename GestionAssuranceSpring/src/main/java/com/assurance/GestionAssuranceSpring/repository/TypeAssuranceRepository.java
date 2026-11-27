package com.assurance.GestionAssuranceSpring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.assurance.GestionAssuranceSpring.entity.TypeAssurance;

public interface TypeAssuranceRepository
        extends JpaRepository<TypeAssurance, Long> {

    boolean existsByNomIgnoreCase(String nom);

    List<TypeAssurance> findByActifTrue();
}