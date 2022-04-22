package com.spring.projectpi.services.interfaces;

import java.util.Set;

public interface AgencyService {
    public com.spring.projectpi.entites.Agency addAgency(com.spring.projectpi.entites.Agency Agency);
    public com.spring.projectpi.entites.Agency updateAgency(com.spring.projectpi.entites.Agency Agency);
    public void deleteAgency(Long id );
    public com.spring.projectpi.entites.Agency getAgency(Long id);
    public Set<com.spring.projectpi.entites.Agency> getAgencys();
    public void affecteUser(Long idA,Long idU);
    public Set<com.spring.projectpi.entites.Agency> getAgencysByRegion(String adresse);
}
