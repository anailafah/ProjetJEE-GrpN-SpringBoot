package com.assurance.GestionAssuranceSpring.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.assurance.GestionAssuranceSpring.entity.Garantie;
import com.assurance.GestionAssuranceSpring.service.GarantieService;

@Controller
@RequestMapping("/garanties")
public class GarantieController {

    private final GarantieService garantieService;

    public GarantieController(GarantieService garantieService) {
        this.garantieService = garantieService;
    }

    @GetMapping
    public String afficherGaranties(Model model) {
        List<Garantie> garanties = garantieService.getAllGaranties();
        model.addAttribute("garanties", garanties);
        return "garanties";
    }
}