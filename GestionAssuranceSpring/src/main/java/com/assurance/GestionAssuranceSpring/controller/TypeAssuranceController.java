package com.assurance.GestionAssuranceSpring.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.assurance.GestionAssuranceSpring.entity.TypeAssurance;
import com.assurance.GestionAssuranceSpring.service.TypeAssuranceService;

@Controller
@RequestMapping("/types-assurance")
public class TypeAssuranceController {

    private final TypeAssuranceService typeAssuranceService;

    public TypeAssuranceController(TypeAssuranceService typeAssuranceService) {
        this.typeAssuranceService = typeAssuranceService;
    }

    @GetMapping
    public String afficherTypesAssurance(Model model) {
        List<TypeAssurance> types = typeAssuranceService.getAllTypesAssurance();
        model.addAttribute("typesAssurance", types);
        return "types-assurance";
    }
}