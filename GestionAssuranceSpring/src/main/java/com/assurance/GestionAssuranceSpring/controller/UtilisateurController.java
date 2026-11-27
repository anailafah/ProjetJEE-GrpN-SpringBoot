package com.assurance.GestionAssuranceSpring.controller;

import java.time.LocalDate;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.assurance.GestionAssuranceSpring.entity.*;
import com.assurance.GestionAssuranceSpring.service.UtilisateurService;

@Controller
@RequestMapping("/utilisateurs")
public class UtilisateurController {

    private final UtilisateurService utilisateurService;

    public UtilisateurController(UtilisateurService utilisateurService) {
        this.utilisateurService = utilisateurService;
    }

    @GetMapping
    public String afficherUtilisateurs(Model model) {
        model.addAttribute("utilisateurs",
                utilisateurService.getAllUtilisateurs());
        return "admin/utilisateurs";
    }

    @GetMapping("/ajouter")
    public String afficherFormulaireAjout() {
        return "admin/ajouter-utilisateur";
    }

    @PostMapping("/ajouter")
    public String ajouterUtilisateur(
            @RequestParam String type,
            @RequestParam String nom,
            @RequestParam String prenom,
            @RequestParam String email,
            @RequestParam String motDePasse,
            @RequestParam(required = false) String telephone,
            @RequestParam(required = false) String adresse,
            @RequestParam(required = false) String dateNaissance,
            @RequestParam(required = false) String matricule,
            @RequestParam(required = false) String service,
            @RequestParam(required = false) String niveauAcces) {

        Utilisateur utilisateur;

        switch (type) {
            case "CLIENT":
                Client client = new Client();
                client.setAdresse(adresse);

                if (dateNaissance != null && !dateNaissance.isBlank()) {
                    client.setDateNaissance(LocalDate.parse(dateNaissance));
                }

                utilisateur = client;
                break;

            case "AGENT":
                Agent agent = new Agent();
                agent.setMatricule(matricule);
                agent.setService(service);
                utilisateur = agent;
                break;
            default:
                throw new IllegalArgumentException("Type d'utilisateur invalide");
        }

        utilisateur.setNom(nom);
        utilisateur.setPrenom(prenom);
        utilisateur.setEmail(email);
        utilisateur.setMotDePasse(motDePasse);
        utilisateur.setTelephone(telephone);
        utilisateur.setActif(true);

        utilisateurService.saveUtilisateur(utilisateur);

        return "redirect:/utilisateurs";
    }

    @PostMapping("/supprimer/{id}")
    public String supprimerUtilisateur(@PathVariable Long id) {
        utilisateurService.deleteUtilisateur(id);
        return "redirect:/utilisateurs";
    }
}