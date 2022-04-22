package com.spring.projectpi.services.implementations;

import com.spring.projectpi.entites.Agency;
import com.spring.projectpi.entites.Appointment;
import com.spring.projectpi.entites.User;
import com.spring.projectpi.repositries.AgencyReposiory;
import com.spring.projectpi.repositries.AppointmentReposiory;
import com.spring.projectpi.repositries.UserReposiory;
import com.spring.projectpi.services.interfaces.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Set;

@Service
public class AppointmentServiceImpl implements AppointmentService {
    @Autowired
    AppointmentReposiory apr;
    @Autowired
    UserReposiory ur;
    @Autowired
    AgencyReposiory ar;

    public Appointment addAppointment(Long ida, Long idu, Date date){
        User user=ur.findById(idu).orElse(null);
        Agency agency=ar.findById(ida).orElse(null);
        Appointment ap=new Appointment();
        ap.setAgency(agency);
        ap.setUser(user);
        ap.setDateAppoitment(date);
        return    apr.save(ap);
    }
    public void store (Appointment Appointment, Long userId){
        User user = ur.findById(userId).orElse(null);
        Appointment rdv2 = new Appointment(Appointment.getDateAppoitment(), user);
        apr.save(rdv2);

    }




    public Appointment updateAppointment(Appointment Appointment){
        return    apr.save(Appointment);
    }
    public void deleteAppointment(Long id ){
        apr.deleteById(id);
    }
    public Appointment getAppointment(Long id){
        return apr.findById(id).orElse(null);
    }
    public Set<Appointment> getAppointments(){
        return (Set<Appointment>) apr.findAll();
    }
}
