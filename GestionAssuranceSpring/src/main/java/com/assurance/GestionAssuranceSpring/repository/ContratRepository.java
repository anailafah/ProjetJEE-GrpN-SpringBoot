package com.assurance.GestionAssuranceSpring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.assurance.GestionAssuranceSpring.entity.Contrat;

public interface ContratRepository extends JpaRepository<Contrat, Long> {

}