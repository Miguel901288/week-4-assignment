package org.example.week4assignment.services;

import org.example.week4assignment.models.Appointment;
import org.example.week4assignment.models.Customer;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class AppointmentService {
    private final HashMap<Integer, Appointment> appointments;
    private int nextId;
    public AppointmentService() {
        appointments = new HashMap<>();
        nextId = 1;
    }

    public List<Appointment> getAppointments() {
        return new ArrayList<>(appointments.values());
    }
    public List<Appointment> getAppointmentsByCustomer(int id){
        ArrayList<Appointment> result = new ArrayList<>();
        for (Appointment appointment : appointments.values()){
            if (appointment.getCustomerId() == id){
                result.add(appointment);
            }
        }
        return result;
    }

    public Appointment createAppointment(Appointment appointment) {
        appointment.setId(nextId++);
        appointments.put(appointment.getId(), appointment);
        return appointment;
    }
    public Appointment getAppointmentById(int id){
        return appointments.get(id);
    }
    public Appointment updateAppointmentStatus(int id, String newStatus){
        Appointment appointment = appointments.get(id);
        if (appointment == null)
            return null;
        appointment.setStatus(newStatus);
        return appointment;
    }
    public void cancelAppointment(int id){
        appointments.remove(id);
    }

}
