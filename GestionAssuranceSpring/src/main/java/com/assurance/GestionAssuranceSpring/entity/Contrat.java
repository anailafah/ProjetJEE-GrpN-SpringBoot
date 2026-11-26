
package com.assurance.GestionAssuranceSpring.entity;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.math.BigDecimal;

@Entity
@Table(name = "contrats")
public class Contrat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "numero_contrat", unique = true, nullable = false)
    private String numeroContrat;
    
    @Column(name = "date_creation")
    private LocalDateTime dateCreation;

    @Column(name = "date_debut")
    private LocalDate dateDebut;

    @Column(name = "date_fin")
    private LocalDate dateFin;

    @Column(precision = 12, scale = 2)
    private BigDecimal montant;

    private String statut;

    @ManyToOne
    @JoinColumn(name = "client_id", nullable = false)
    private Client client;

    @ManyToOne
    @JoinColumn(name = "type_assurance_id", nullable = false)
    private TypeAssurance typeAssurance;

    @ManyToMany
    @JoinTable(
        name = "contrat_garanties",
        joinColumns = @JoinColumn(name = "contrat_id"),
        inverseJoinColumns = @JoinColumn(name = "garantie_id")
    )
    private List<Garantie> garanties = new ArrayList<>();

    public Contrat() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public LocalDateTime getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(LocalDateTime dateCreation) {
        this.dateCreation = dateCreation;
    }

    public String getNumeroContrat() {
        return numeroContrat;
    }

    public void setNumeroContrat(String numeroContrat) {
        this.numeroContrat = numeroContrat;
    }

    public LocalDate getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(LocalDate dateDebut) {
        this.dateDebut = dateDebut;
    }

    public LocalDate getDateFin() {
        return dateFin;
    }

    public void setDateFin(LocalDate dateFin) {
        this.dateFin = dateFin;
    }

    public BigDecimal getMontant() {
        return montant;
    }

    public void setMontant(BigDecimal montant) {
        this.montant = montant;
    }

    public String getStatut() {
        return statut;
    }

    public void setStatut(String statut) {
        this.statut = statut;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public TypeAssurance getTypeAssurance() {
        return typeAssurance;
    }

    public void setTypeAssurance(TypeAssurance typeAssurance) {
        this.typeAssurance = typeAssurance;
    }

    public List<Garantie> getGaranties() {
        return garanties;
    }

    public void setGaranties(List<Garantie> garanties) {
        this.garanties = garanties;
    }
}
