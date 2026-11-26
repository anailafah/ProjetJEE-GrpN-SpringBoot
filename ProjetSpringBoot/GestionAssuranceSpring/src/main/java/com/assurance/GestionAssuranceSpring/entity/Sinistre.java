package com.assurance.GestionAssuranceSpring.entity;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.math.BigDecimal;

@Entity
@Table(name = "sinistres")
public class Sinistre {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "numero_sinistre", unique = true, nullable = false)
    private String numeroSinistre;

    @Column(columnDefinition = "TEXT")
    private String description;

    @Column(name = "date_sinistre")
    private LocalDate dateSinistre;

    @Column(name = "date_declaration")
    private LocalDateTime dateDeclaration;

    private String statut;

    @Column(name = "montant_demande", precision = 12, scale = 2)
    private BigDecimal montantDemande;

    @Column(name = "montant_indemnisation", precision = 12, scale = 2)
    private BigDecimal montantIndemnisation;

    @ManyToOne
    @JoinColumn(name = "contrat_id", nullable = false)
    private Contrat contrat;

    public Sinistre() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumeroSinistre() {
        return numeroSinistre;
    }

    public void setNumeroSinistre(String numeroSinistre) {
        this.numeroSinistre = numeroSinistre;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getDateSinistre() {
        return dateSinistre;
    }

    public void setDateSinistre(LocalDate dateSinistre) {
        this.dateSinistre = dateSinistre;
    }

    public LocalDateTime getDateDeclaration() {
        return dateDeclaration;
    }

    public void setDateDeclaration(LocalDateTime dateDeclaration) {
        this.dateDeclaration = dateDeclaration;
    }

    public String getStatut() {
        return statut;
    }

    public void setStatut(String statut) {
        this.statut = statut;
    }

    public BigDecimal getMontantDemande() {
        return montantDemande;
    }

    public void setMontantDemande(BigDecimal montantDemande) {
        this.montantDemande = montantDemande;
    }

    public BigDecimal getMontantIndemnisation() {
        return montantIndemnisation;
    }

    public void setMontantIndemnisation(BigDecimal montantIndemnisation) {
        this.montantIndemnisation = montantIndemnisation;
    }

    public Contrat getContrat() {
        return contrat;
    }

    public void setContrat(Contrat contrat) {
        this.contrat = contrat;
    }
}
