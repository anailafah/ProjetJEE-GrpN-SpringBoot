package com.assurance.GestionAssuranceSpring.controller;

import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.assurance.GestionAssuranceSpring.entity.Contrat;
import com.assurance.GestionAssuranceSpring.service.ContratService;

import org.springframework.security.access.prepost.PreAuthorize;

@Controller
@RequestMapping("/agent/contrats")
@PreAuthorize("hasRole('AGENT')")
public class ContratController {

    private final ContratService contratService;

    public ContratController(ContratService contratService) {
        this.contratService = contratService;
    }

    @GetMapping
    public String afficherContrats(
            @RequestParam(required = false) String recherche,
            Model model) {

        List<Contrat> contrats = contratService.getAllContrats();

        // Recherche par numéro, nom ou prénom du client
        if (recherche != null && !recherche.trim().isEmpty()) {

            String motCle = recherche.trim().toLowerCase(Locale.ROOT);

            contrats = contrats.stream()
                    .filter(contrat ->
                            (contrat.getNumeroContrat() != null
                                    && contrat.getNumeroContrat()
                                            .toLowerCase(Locale.ROOT)
                                            .contains(motCle))

                            ||

                            (contrat.getClient() != null
                                    && (
                                            (contrat.getClient().getNom() != null
                                                    && contrat.getClient().getNom()
                                                            .toLowerCase(Locale.ROOT)
                                                            .contains(motCle))

                                            ||

                                            (contrat.getClient().getPrenom() != null
                                                    && contrat.getClient().getPrenom()
                                                            .toLowerCase(Locale.ROOT)
                                                            .contains(motCle))
                                    ))
                    )
                    .collect(Collectors.toList());
        }

        model.addAttribute("contrats", contrats);
        model.addAttribute("recherche", recherche);

        return "contrats";
    }
}