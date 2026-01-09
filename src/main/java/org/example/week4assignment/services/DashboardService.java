package org.example.week4assignment.services;

import org.example.week4assignment.models.Appointment;
import org.example.week4assignment.models.Ticket;

public class DashboardService {
    CustomerService customerService;
    AppointmentService appointmentService;
    TicketService ticketService;

    public DashboardService(CustomerService customerService, AppointmentService appointmentService, TicketService ticketService) {
        this.customerService = customerService;
        this.appointmentService = appointmentService;
        this.ticketService = ticketService;
    }

    public int getCustomerCount(){
        return customerService.getCustomers().size();
    }
    public int getAppointmentCount(){
        return appointmentService.getAppointments().size();
    }
    public int getOpenTicketCount(){
        return ticketService.getTicketsByStatus("open").size();
    }
}
