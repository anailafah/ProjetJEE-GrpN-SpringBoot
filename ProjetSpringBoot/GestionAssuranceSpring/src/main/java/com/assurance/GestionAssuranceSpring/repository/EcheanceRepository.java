package com.assurance.GestionAssuranceSpring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.assurance.GestionAssuranceSpring.entity.Echeance;

public interface EcheanceRepository extends JpaRepository<Echeance, Long> {

}