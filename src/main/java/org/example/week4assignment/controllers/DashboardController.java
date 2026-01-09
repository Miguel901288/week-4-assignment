package org.example.week4assignment.controllers;

import org.example.week4assignment.services.AppointmentService;
import org.example.week4assignment.services.CustomerService;
import org.example.week4assignment.services.DashboardService;
import org.example.week4assignment.services.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/dashboard")
public class DashboardController {
    @Autowired
    private DashboardService dashboardService;
    public DashboardController(DashboardService dashboardService){
        this.dashboardService = dashboardService;
    }

    @GetMapping("/tickets")
    public int getTicketsCount(){
        return dashboardService.getOpenTicketCount();
    }
    @GetMapping("/customers")
    public int getCustomersCount(){
        return dashboardService.getCustomerCount();
    }
    @GetMapping("/appointments")
    public int getAppointmentsCount(){
        return dashboardService.getAppointmentCount();
    }

}
