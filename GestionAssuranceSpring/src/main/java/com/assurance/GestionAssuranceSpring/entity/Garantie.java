package com.assurance.GestionAssuranceSpring.entity;

import java.math.BigDecimal;
import jakarta.persistence.*;

@Entity
@Table(name = "garanties")
public class Garantie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String nom;

    @Column(columnDefinition = "TEXT")
    private String description;

    @Column(name = "montant_maximal", precision = 12, scale = 2)
    private BigDecimal montantCouverture;

    private boolean actif = true;

    public Garantie() {
    }

    public Garantie(String nom, String description, BigDecimal montantCouverture) {
        this.nom = nom;
        this.description = description;
        this.montantCouverture = montantCouverture;
        this.actif = true;
    }

    // Getters et setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getMontantCouverture() {
        return montantCouverture;
    }

    public void setMontantCouverture(BigDecimal montantCouverture) {
        this.montantCouverture = montantCouverture;
    }

    public boolean isActif() {
        return actif;
    }

    public void setActif(boolean actif) {
        this.actif = actif;
    }
}