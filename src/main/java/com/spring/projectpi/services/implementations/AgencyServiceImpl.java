package com.spring.projectpi.services.implementations;

import com.spring.projectpi.entites.Agency;
import com.spring.projectpi.entites.User;
import com.spring.projectpi.repositries.AgencyReposiory;
import com.spring.projectpi.repositries.UserReposiory;
import com.spring.projectpi.services.interfaces.AgencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class AgencyServiceImpl implements AgencyService {
    @Autowired
    AgencyReposiory ar;
    @Autowired
    UserReposiory ur;
    public Agency addAgency(Agency Agency)
    {
        return    ar.save(Agency);
    }
    public Agency updateAgency(Agency Agency){
        return    ar.save(Agency);
    }
    public void deleteAgency(Long id ){
        ar.deleteById(id);
    }
    public Agency getAgency(Long id){
        return ar.findById(id).orElse(null);
    }
    public Set<Agency> getAgencys(){
        List<Agency> ListAgencies ;
        return (Set<Agency>) (ListAgencies = (List<Agency>) ar.findAll());
    }
    public void affecteUser(Long idA,Long idU){
        Agency agency=ar.findById(idA).orElse(null);
        User user=ur.findById(idU).orElse(null);
        agency.getUsers().add(user);
        ar.save(agency);
    }
    public Set<Agency> getAgencysByRegion(String adresse){
        Set<Agency> agencies= (Set<Agency>) ar.findAll();
        return agencies.stream().filter(a->a.getAdresse().equals(adresse)).collect(Collectors.toSet());



    }

}
