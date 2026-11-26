
package com.assurance.GestionAssuranceSpring.entity;

import jakarta.persistence.*;

@Entity
@DiscriminatorValue("CLIENT")
public class Client extends Utilisateur {

    @Column(length = 255)
    private String adresse;
    
    @Column(name = "date_naissance")
    private java.time.LocalDate dateNaissance;

    public Client() {
        super();
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public java.time.LocalDate getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(java.time.LocalDate dateNaissance) {
        this.dateNaissance = dateNaissance;
    }
}
