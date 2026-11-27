package com.assurance.GestionAssuranceSpring.entity;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;
import java.math.BigDecimal;

import jakarta.persistence.*;


@Entity
@Table(name = "types_assurance")
public class TypeAssurance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Le nom est obligatoire")
    @Size(max = 100, message = "Le nom ne doit pas dépasser 100 caractères")
    @Column(nullable = false, unique = true, length = 100)
    private String nom;

    private String description;

    @Positive(message = "La durée doit être positive")
    @Column(name = "duree_mois")
    private Integer dureeMois;

    @NotNull(message = "Le tarif de base est obligatoire")
    @PositiveOrZero(message = "Le tarif doit être positif ou égal à zéro")
    @Column(name = "prix_base", nullable = false, precision = 12, scale = 2)
    private BigDecimal tarifBase;

    @Column(nullable = false)
    private boolean actif = true;

    public TypeAssurance() {
    }

    public TypeAssurance(String nom, String description, BigDecimal tarifBase) {
        this.nom = nom;
        this.description = description;
        this.tarifBase = tarifBase;
    }

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

    public Integer getDureeMois() {
        return dureeMois;
    }

    public void setDureeMois(Integer dureeMois) {
        this.dureeMois = dureeMois;
    }

    public BigDecimal getTarifBase() {
        return tarifBase;
    }

    public void setTarifBase(BigDecimal tarifBase) {
        this.tarifBase = tarifBase;
    }

    public boolean isActif() {
        return actif;
    }

    public void setActif(boolean actif) {
        this.actif = actif;
    }
}