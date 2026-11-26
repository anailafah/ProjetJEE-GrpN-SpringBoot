
package com.assurance.GestionAssuranceSpring.entity;

import jakarta.persistence.*;

@Entity
@DiscriminatorValue("AGENT")
public class Agent extends Utilisateur {

    @Column(unique = true, length = 50)
    private String matricule;

    @Column(length = 100)
    private String service;

    public Agent() {
        super();
    }

    public String getMatricule() {
        return matricule;
    }

    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }
}
