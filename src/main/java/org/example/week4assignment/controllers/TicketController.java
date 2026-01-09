package org.example.week4assignment.controllers;

import org.example.week4assignment.models.Appointment;
import org.example.week4assignment.models.Ticket;
import org.example.week4assignment.services.AppointmentService;
import org.example.week4assignment.services.CustomerService;
import org.example.week4assignment.services.TicketService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tickets")
public class TicketController {
    private final TicketService ticketService;

    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }
    @GetMapping
    public List<Ticket> getTickets(@RequestParam String status) {
        return (status == null) ?
                ticketService.getTickets() : ticketService.getTicketsByStatus(status);
    }

    public Ticket createTicket(Ticket ticket) {
        return ticketService.createTicket(ticket);
    }

    @GetMapping("/{id}")
    public Ticket getTicketById(@PathVariable int id) {
        return ticketService.getTicketById(id);
    }

    @PatchMapping("/{id}")
    public Ticket updateTicketStatus(@PathVariable int id, @RequestBody String status) {
        return ticketService.updateTicketStatus(id, status);
    }
}
