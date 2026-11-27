package com.assurance.GestionAssuranceSpring.service;

import java.math.BigDecimal;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

import org.springframework.stereotype.Service;

import com.assurance.GestionAssuranceSpring.entity.Client;
import com.assurance.GestionAssuranceSpring.entity.Contrat;
import com.assurance.GestionAssuranceSpring.entity.Sinistre;
import com.assurance.GestionAssuranceSpring.repository.UtilisateurRepository;
import com.assurance.GestionAssuranceSpring.repository.ContratRepository;
import com.assurance.GestionAssuranceSpring.repository.SinistreRepository;
import com.assurance.GestionAssuranceSpring.repository.PaiementRepository;

@Service
public class DashboardService {

    private final UtilisateurRepository utilisateurRepository;
    private final ContratRepository contratRepository;
    private final SinistreRepository sinistreRepository;
    private final PaiementRepository paiementRepository;

    public DashboardService(
            UtilisateurRepository utilisateurRepository,
            ContratRepository contratRepository,
            SinistreRepository sinistreRepository,
            PaiementRepository paiementRepository) {

        this.utilisateurRepository = utilisateurRepository;
        this.contratRepository = contratRepository;
        this.sinistreRepository = sinistreRepository;
        this.paiementRepository = paiementRepository;
    }

    public Map<String, Object> getStatistiques() {

        var utilisateurs = utilisateurRepository.findAll();
        var contrats = contratRepository.findAll();
        var sinistres = sinistreRepository.findAll();
        var paiements = paiementRepository.findAll();

        long nombreClients = utilisateurs.stream()
                .filter(Client.class::isInstance)
                .count();

        long contratsActifs = contrats.stream()
                .filter(c -> "ACTIF".equalsIgnoreCase(c.getStatut()))
                .count();

        long sinistresEnAttente = sinistres.stream()
                .filter(s -> "EN_ATTENTE".equalsIgnoreCase(s.getStatut())
                          || "EN ATTENTE".equalsIgnoreCase(s.getStatut()))
                .count();

        BigDecimal montantTotal = paiements.stream()
                .map(p -> p.getMontant() == null
                        ? BigDecimal.ZERO : p.getMontant())
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        // Contrats par type d'assurance
        Map<String, Long> contratsParType = new TreeMap<>();

        for (Contrat contrat : contrats) {
            if (contrat.getTypeAssurance() != null) {
                String nom = contrat.getTypeAssurance().getNom();

                contratsParType.merge(nom, 1L, Long::sum);
            }
        }

        // Sinistres par statut
        Map<String, Long> sinistresParStatut = new TreeMap<>();

        for (Sinistre sinistre : sinistres) {
            String statut = sinistre.getStatut() != null
                    ? sinistre.getStatut() : "Non renseigné";

            sinistresParStatut.merge(statut, 1L, Long::sum);
        }

        // Contrats par mois
        Map<YearMonth, Long> contratsMois = new TreeMap<>();

        for (Contrat contrat : contrats) {
            if (contrat.getDateCreation() != null) {
                YearMonth mois = YearMonth.from(contrat.getDateCreation());

                contratsMois.merge(mois, 1L, Long::sum);
            }
        }

        Map<String, Long> contratsParMois = new LinkedHashMap<>();

        DateTimeFormatter formatter =
                DateTimeFormatter.ofPattern("MM/yyyy");

        contratsMois.forEach((mois, nombre) ->
                contratsParMois.put(mois.format(formatter), nombre));

        // Résultat final
        Map<String, Object> statistiques = new LinkedHashMap<>();

        statistiques.put("nombreUtilisateurs", utilisateurs.size());
        statistiques.put("nombreClients", nombreClients);
        statistiques.put("nombreContrats", contrats.size());
        statistiques.put("nombreSinistres", sinistres.size());
        statistiques.put("contratsActifs", contratsActifs);
        statistiques.put("sinistresEnAttente", sinistresEnAttente);
        statistiques.put("nombrePaiements", paiements.size());
        statistiques.put("montantTotalPaiements", montantTotal);

        statistiques.put("contratsParType", contratsParType);
        statistiques.put("contratsParMois", contratsParMois);
        statistiques.put("sinistresParStatut", sinistresParStatut);

        return statistiques;
    }
}
