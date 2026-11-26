package com.assurance.GestionAssuranceSpring.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.assurance.GestionAssuranceSpring.entity.Sinistre;
import com.assurance.GestionAssuranceSpring.service.SinistreService;

@RestController
@RequestMapping("/api/sinistres")
public class SinistreController {

    private final SinistreService sinistreService;

    public SinistreController(SinistreService sinistreService) {
        this.sinistreService = sinistreService;
    }

    @GetMapping
    public List<Sinistre> getAllSinistres() {
        return sinistreService.getAllSinistres();
    }

    @GetMapping("/{id}")
    public Sinistre getSinistreById(@PathVariable Long id) {
        return sinistreService.getSinistreById(id);
    }

    @PostMapping
    public Sinistre saveSinistre(@RequestBody Sinistre sinistre) {
        return sinistreService.saveSinistre(sinistre);
    }

    @DeleteMapping("/{id}")
    public void deleteSinistre(@PathVariable Long id) {
        sinistreService.deleteSinistre(id);
    }
}