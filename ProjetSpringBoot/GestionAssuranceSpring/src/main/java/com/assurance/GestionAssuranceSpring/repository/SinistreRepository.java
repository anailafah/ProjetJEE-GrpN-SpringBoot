package com.assurance.GestionAssuranceSpring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.assurance.GestionAssuranceSpring.entity.Sinistre;

public interface SinistreRepository extends JpaRepository<Sinistre, Long> {

}