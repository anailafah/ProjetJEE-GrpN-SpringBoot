package com.assurance.GestionAssuranceSpring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.assurance.GestionAssuranceSpring.entity.Utilisateur;

public interface UtilisateurRepository extends JpaRepository<Utilisateur, Long> {
    
}