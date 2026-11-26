package com.assurance.GestionAssuranceSpring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.assurance.GestionAssuranceSpring.entity.Paiement;

public interface PaiementRepository extends JpaRepository<Paiement, Long> {

}