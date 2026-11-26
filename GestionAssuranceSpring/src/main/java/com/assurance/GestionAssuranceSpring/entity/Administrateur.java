
package com.assurance.GestionAssuranceSpring.entity;

import jakarta.persistence.*;

@Entity
@DiscriminatorValue("ADMIN")
public class Administrateur extends Utilisateur {

    @Column(name = "niveau_acces",length = 50)
    private String niveauAcces;

    public Administrateur() {
        super();
    }

    public String getNiveauAcces() {
        return niveauAcces;
    }

    public void setNiveauAcces(String niveauAcces) {
        this.niveauAcces = niveauAcces;
    }
}
