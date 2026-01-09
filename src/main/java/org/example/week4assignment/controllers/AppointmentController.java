package org.example.week4assignment.controllers;

import org.example.week4assignment.models.Appointment;
import org.example.week4assignment.services.AppointmentService;
import org.example.week4assignment.services.CustomerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/appointments")
public class AppointmentController {
    private final AppointmentService appointmentService;

    public AppointmentController(AppointmentService appointmentService) {
        this.appointmentService = appointmentService;
    }
    @GetMapping
    public List<Appointment> getAppointments(@RequestParam(required = false) String id) {
        if (id != null){
            return appointmentService.getAppointmentsByCustomer(Integer.parseInt(id));
        }
        return appointmentService.getAppointments();
    }

    public Appointment createAppointment(Appointment appointment) {
        return appointmentService.createAppointment(appointment);
    }

    @GetMapping("/{id}")
    public Appointment getAppointmentById(@PathVariable int id) {
        return appointmentService.getAppointmentById(id);
    }

    @DeleteMapping("/{id}")
    public void cancelAppointment(@PathVariable int id) {
        appointmentService.cancelAppointment(id);
    }
}
