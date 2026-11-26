package com.assurance.GestionAssuranceSpring.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.assurance.GestionAssuranceSpring.entity.Contrat;
import com.assurance.GestionAssuranceSpring.service.ContratService;

@Controller
@RequestMapping("/contrats")
public class ContratController {

    private final ContratService contratService;

    public ContratController(ContratService contratService) {
        this.contratService = contratService;
    }

    @GetMapping
    public String afficherContrats(Model model) {
        List<Contrat> contrats = contratService.getAllContrats();
        model.addAttribute("contrats", contrats);
        return "contrats";
    }
}