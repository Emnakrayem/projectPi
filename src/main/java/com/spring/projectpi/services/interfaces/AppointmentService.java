package com.spring.projectpi.services.interfaces;

import com.spring.projectpi.entites.Appointment;

import java.util.Date;
import java.util.Set;

public interface AppointmentService {

    public void deleteAppointment(Long id );
    public Appointment getAppointment(Long id);
    public Set<Appointment> getAppointments();
    public Appointment updateAppointment(Appointment Appointment);
    public void store (Appointment Appointment, Long userId);
}
