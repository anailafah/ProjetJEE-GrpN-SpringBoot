package com.assurance.GestionAssuranceSpring.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.assurance.GestionAssuranceSpring.entity.Echeance;
import com.assurance.GestionAssuranceSpring.service.EcheanceService;

@RestController
@RequestMapping("/api/echeances")
public class EcheanceController {

    private final EcheanceService echeanceService;

    public EcheanceController(EcheanceService echeanceService) {
        this.echeanceService = echeanceService;
    }

    @GetMapping
    public List<Echeance> getAllEcheances() {
        return echeanceService.getAllEcheances();
    }

    @GetMapping("/{id}")
    public Echeance getEcheanceById(@PathVariable Long id) {
        return echeanceService.getEcheanceById(id);
    }

    @PostMapping
    public Echeance saveEcheance(@RequestBody Echeance echeance) {
        return echeanceService.saveEcheance(echeance);
    }

    @DeleteMapping("/{id}")
    public void deleteEcheance(@PathVariable Long id) {
        echeanceService.deleteEcheance(id);
    }
}