package com.spring.projectpi.services.interfaces;

import com.spring.projectpi.entites.Personne;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

public interface UserService extends UserDetailsService {
    public com.spring.projectpi.entites.User addUser(com.spring.projectpi.entites.User user);
    public com.spring.projectpi.entites.User updateUser(com.spring.projectpi.entites.User user);
    public void deleteUser(Long id );
    public com.spring.projectpi.entites.User getUser(Long id);
    public Set<com.spring.projectpi.entites.User> getUsers();
    public AtomicInteger getUserbyTypePersonne(Personne personne);
}
