package com.assurance.GestionAssuranceSpring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.assurance.GestionAssuranceSpring.service.DashboardService;

@Controller
public class AdminController {

    private final DashboardService dashboardService;

    public AdminController(DashboardService dashboardService) {
        this.dashboardService = dashboardService;
    }

    @GetMapping("/admin/dashboard")
    public String dashboard(Model model) {

        model.addAttribute("statistiques",
                dashboardService.getStatistiques());

        return "admin/dashboard";
    }
}
