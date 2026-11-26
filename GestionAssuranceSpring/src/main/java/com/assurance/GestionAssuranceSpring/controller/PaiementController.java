package com.assurance.GestionAssuranceSpring.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.assurance.GestionAssuranceSpring.entity.Paiement;
import com.assurance.GestionAssuranceSpring.service.PaiementService;

@RestController
@RequestMapping("/api/paiements")
public class PaiementController {

    private final PaiementService paiementService;

    public PaiementController(PaiementService paiementService) {
        this.paiementService = paiementService;
    }

    @GetMapping
    public List<Paiement> getAllPaiements() {
        return paiementService.getAllPaiements();
    }

    @GetMapping("/{id}")
    public Paiement getPaiementById(@PathVariable Long id) {
        return paiementService.getPaiementById(id);
    }

    @PostMapping
    public Paiement savePaiement(@RequestBody Paiement paiement) {
        return paiementService.savePaiement(paiement);
    }

    @DeleteMapping("/{id}")
    public void deletePaiement(@PathVariable Long id) {
        paiementService.deletePaiement(id);
    }
}