package com.spring.projectpi.controllers;

import com.spring.projectpi.entites.Appointment;
import com.spring.projectpi.services.implementations.AppointmentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.Set;

@RestController
@RequestMapping("/Appointment")
public class AppointmentController {
    @Autowired
    AppointmentServiceImpl as;
    @PostMapping("/{ida}/add/{idu}/{date}")
    @ResponseBody
    public Appointment addAppointment(@PathVariable("ida") Long ida,@PathVariable("idu") Long idu,@PathVariable("date") Date date){
        return    as.addAppointment(ida ,idu,date);
    }
    @PutMapping("/update")
    @ResponseBody
    public Appointment updateAppointment(@RequestBody Appointment Appointment){
        return    as.updateAppointment(Appointment);
    }
    @DeleteMapping("/delete/{id}")
    @ResponseBody
    public void deleteAppointment(@PathVariable("id") Long id ){
        as.deleteAppointment(id);
    }
    @GetMapping("/get/{id}")
    @ResponseBody
    public Appointment getAppointment(@PathVariable("id") Long id){
        return as.getAppointment(id);
    }
    @GetMapping("/get-all")
    @ResponseBody
    public Set<Appointment> getAppointments(){
        return as.getAppointments();
    }
   
}
