package com.assurance.GestionAssuranceSpring.service;

import java.util.List;
import org.springframework.stereotype.Service;

import com.assurance.GestionAssuranceSpring.entity.TypeAssurance;
import com.assurance.GestionAssuranceSpring.repository.TypeAssuranceRepository;

@Service
public class TypeAssuranceService {

    private final TypeAssuranceRepository typeAssuranceRepository;

    public TypeAssuranceService(TypeAssuranceRepository typeAssuranceRepository) {
        this.typeAssuranceRepository = typeAssuranceRepository;
    }

    public List<TypeAssurance> getAllTypesAssurance() {
        return typeAssuranceRepository.findAll();
    }

    public TypeAssurance getTypeAssuranceById(Long id) {
        return typeAssuranceRepository.findById(id).orElse(null);
    }

    public TypeAssurance saveTypeAssurance(TypeAssurance typeAssurance) {
        return typeAssuranceRepository.save(typeAssurance);
    }

    public void deleteTypeAssurance(Long id) {
        typeAssuranceRepository.deleteById(id);
    }
}