package com.assurance.GestionAssuranceSpring.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.assurance.GestionAssuranceSpring.entity.TypeAssurance;
import com.assurance.GestionAssuranceSpring.service.TypeAssuranceService;

@Controller
@RequestMapping("/types-assurance")
public class TypeAssuranceController {

    private final TypeAssuranceService typeAssuranceService;

    public TypeAssuranceController(TypeAssuranceService typeAssuranceService) {
        this.typeAssuranceService = typeAssuranceService;
    }

    // Afficher tous les types d'assurance
    @GetMapping
    public String afficherTypesAssurance(Model model) {

        List<TypeAssurance> types = typeAssuranceService.lister();

        model.addAttribute("typesAssurance", types);

        return "admin/types-assurance";
    }

    // Afficher le formulaire d'ajout
    @GetMapping("/ajouter")
    public String afficherFormulaireAjout(Model model) {

        model.addAttribute("typeAssurance", new TypeAssurance());

        return "admin/modifier-type-assurance";
    }

    // Ajouter un type d'assurance
    @PostMapping("/ajouter")
    public String ajouterTypeAssurance(
            @ModelAttribute TypeAssurance typeAssurance,
            RedirectAttributes redirectAttributes) {

        try {

            typeAssuranceService.ajouter(typeAssurance);

            redirectAttributes.addFlashAttribute(
                    "success",
                    "Type d'assurance ajouté avec succès."
            );

            return "redirect:/types-assurance";

        } catch (IllegalArgumentException e) {

            redirectAttributes.addFlashAttribute("error", e.getMessage());

            return "redirect:/types-assurance/ajouter";
        }
    }

    // Afficher le formulaire de modification
    @GetMapping("/modifier/{id}")
    public String afficherFormulaireModification(
            @PathVariable Long id,
            Model model,
            RedirectAttributes redirectAttributes) {

        TypeAssurance type = typeAssuranceService.trouverParId(id);

        if (type == null) {

            redirectAttributes.addFlashAttribute(
                    "error",
                    "Type d'assurance introuvable."
            );

            return "redirect:/types-assurance";
        }

        model.addAttribute("typeAssurance", type);

        return "admin/modifier-type-assurance";
    }

    // Modifier un type d'assurance
    @PostMapping("/modifier/{id}")
    public String modifierTypeAssurance(
            @PathVariable Long id,
            @ModelAttribute TypeAssurance typeAssurance,
            RedirectAttributes redirectAttributes) {

        try {

            typeAssurance.setId(id);

            typeAssuranceService.modifier(typeAssurance);

            redirectAttributes.addFlashAttribute(
                    "success",
                    "Type d'assurance modifié avec succès."
            );

            return "redirect:/types-assurance";

        } catch (IllegalArgumentException e) {

            redirectAttributes.addFlashAttribute("error", e.getMessage());

            return "redirect:/types-assurance/modifier/" + id;
        }
    }

    // Consulter les détails
    @GetMapping("/{id}")
    public String afficherDetails(
            @PathVariable Long id,
            Model model,
            RedirectAttributes redirectAttributes) {

        TypeAssurance type = typeAssuranceService.trouverParId(id);

        if (type == null) {

            redirectAttributes.addFlashAttribute(
                    "error",
                    "Type d'assurance introuvable."
            );

            return "redirect:/types-assurance";
        }

        model.addAttribute("typeAssurance", type);

        return "admin/details-type-assurance";
    }

    // Désactiver un type d'assurance
    @PostMapping("/desactiver/{id}")
    public String desactiverTypeAssurance(
            @PathVariable Long id,
            RedirectAttributes redirectAttributes) {

        try {

            typeAssuranceService.desactiver(id);

            redirectAttributes.addFlashAttribute(
                    "success",
                    "Type d'assurance désactivé avec succès."
            );

        } catch (IllegalArgumentException e) {

            redirectAttributes.addFlashAttribute("error", e.getMessage());
        }

        return "redirect:/types-assurance";
    }
}