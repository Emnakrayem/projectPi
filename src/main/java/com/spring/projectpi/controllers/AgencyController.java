package com.spring.projectpi.controllers;

import com.spring.projectpi.entites.Agency;
import com.spring.projectpi.services.implementations.AgencyServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Set;


@RestController
@RequestMapping("/Agency")
public class AgencyController {
    @Autowired
    AgencyServiceImpl as;
    @PostMapping("/add")
    @ResponseBody
    public Agency addAgency(@RequestBody Agency Agency){
        return    as.addAgency(Agency);
    }
    @PutMapping("/update")
    @ResponseBody
    public Agency updateAgency(@RequestBody Agency Agency){
        return    as.updateAgency(Agency);
    }
    @DeleteMapping("/delete/{id}")
    @ResponseBody
    public void deleteAgency(@PathVariable("id") Long id ) {
        as.deleteAgency(id);
    }
    @GetMapping("/get/{id}")
    @ResponseBody
    public Agency getAgency(@PathVariable("id") Long id){
        return as.getAgency(id);
    }
    @GetMapping("/get-all")
    @ResponseBody
    public Set<Agency> getAgencys(){
        return as.getAgencys();
    }
    @PutMapping("/{idA}/affecte/{idU}")
    @ResponseBody
    public void affecteUser(@PathVariable("idA") Long ida,@PathVariable("idU") Long idu){
        as.affecteUser(ida, idu);
    }
    @GetMapping("/getByRegion/{addresse}")
    @ResponseBody
    public Set<Agency> getAgencysByRegion(@PathVariable("addresse") String adresse){

        return as.getAgencysByRegion(adresse);

    }
}
