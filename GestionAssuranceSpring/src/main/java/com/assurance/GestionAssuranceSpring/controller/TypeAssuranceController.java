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
        List<TypeAssurance> types = typeAssuranceService.getAllTypesAssurance();
        model.addAttribute("typesAssurance", types);
        return "admin/types-assurance";
    }

    // Afficher le formulaire d'ajout
    @GetMapping("/ajouter")
    public String afficherFormulaireAjout(Model model) {
        model.addAttribute("typeAssurance", new TypeAssurance());
        return "admin/modifier-type-assurance";
    }

    // Enregistrer un nouveau type
    @PostMapping("/ajouter")
    public String ajouterTypeAssurance(
            @ModelAttribute TypeAssurance typeAssurance,
            RedirectAttributes redirectAttributes) {

        typeAssuranceService.saveTypeAssurance(typeAssurance);

        redirectAttributes.addFlashAttribute(
                "success",
                "Type d'assurance ajouté avec succès."
        );

        return "redirect:/types-assurance";
    }

    // Afficher le formulaire de modification
    @GetMapping("/modifier/{id}")
    public String afficherFormulaireModification(
            @PathVariable Long id,
            Model model,
            RedirectAttributes redirectAttributes) {

        TypeAssurance type = typeAssuranceService.getTypeAssuranceById(id);

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

    // Enregistrer les modifications
    @PostMapping("/modifier/{id}")
    public String modifierTypeAssurance(
            @PathVariable Long id,
            @ModelAttribute TypeAssurance typeAssurance,
            RedirectAttributes redirectAttributes) {

        TypeAssurance existant = typeAssuranceService.getTypeAssuranceById(id);

        if (existant == null) {
            redirectAttributes.addFlashAttribute(
                    "error",
                    "Type d'assurance introuvable."
            );
            return "redirect:/types-assurance";
        }

        typeAssurance.setId(id);
        typeAssuranceService.saveTypeAssurance(typeAssurance);

        redirectAttributes.addFlashAttribute(
                "success",
                "Type d'assurance modifié avec succès."
        );

        return "redirect:/types-assurance";
    }

    // Consulter les détails
    @GetMapping("/{id}")
    public String afficherDetails(
            @PathVariable Long id,
            Model model,
            RedirectAttributes redirectAttributes) {

        TypeAssurance type = typeAssuranceService.getTypeAssuranceById(id);

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

    // Supprimer un type
    @PostMapping("/supprimer/{id}")
    public String supprimerTypeAssurance(
            @PathVariable Long id,
            RedirectAttributes redirectAttributes) {

        TypeAssurance type = typeAssuranceService.getTypeAssuranceById(id);

        if (type == null) {
            redirectAttributes.addFlashAttribute(
                    "error",
                    "Type d'assurance introuvable."
            );
            return "redirect:/types-assurance";
        }

        typeAssuranceService.deleteTypeAssurance(id);

        redirectAttributes.addFlashAttribute(
                "success",
                "Type d'assurance supprimé avec succès."
        );

        return "redirect:/types-assurance";
    }
}