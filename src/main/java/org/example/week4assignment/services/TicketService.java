package org.example.week4assignment.services;

import org.example.week4assignment.models.Appointment;
import org.example.week4assignment.models.Customer;
import org.example.week4assignment.models.Ticket;
import org.springframework.stereotype.Service;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class TicketService {
    private final HashMap<Integer, Ticket> tickets;
    private int nextId;

    public TicketService() {
        tickets = new HashMap<>();
        nextId = 1;
    }

    public List<Ticket> getTickets() {
        return new ArrayList<>(tickets.values());
    }

    public List<Ticket> getTicketsByStatus(String status) {
        ArrayList<Ticket> result = new ArrayList<>();
        for (Ticket ticket : tickets.values()) {
            if (ticket.getStatus().equals(status)) {
                result.add(ticket);
            }
        }
        return result;
    }


    public Ticket createTicket(Ticket ticket) {
        ticket.setId(nextId++);
        tickets.put(ticket.getId(), ticket);
        return ticket;
    }

    public Ticket getTicketById(int id) {
        return tickets.get(id);
    }

    public Ticket updateTicketStatus(int id, String newStatus) {
        Ticket ticket = tickets.get(id);
        if (ticket == null)
            return null;
        ticket.setStatus(newStatus);
        return ticket;
    }


}
