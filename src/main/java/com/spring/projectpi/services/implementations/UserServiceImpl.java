package com.spring.projectpi.services.implementations;

import com.spring.projectpi.Registration.ConfirmationToken;
import com.spring.projectpi.Registration.ConfirmationTokenService;
import com.spring.projectpi.entites.Personne;
import com.spring.projectpi.entites.Role;
import com.spring.projectpi.entites.User;
import com.spring.projectpi.repositries.RoleRepo;
import com.spring.projectpi.repositries.UserReposiory;
import com.spring.projectpi.services.interfaces.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService, UserDetailsService {
    private final UserReposiory ur;
    private final RoleRepo roleRepo;
    private final PasswordEncoder passwordEncoder;
    private final ConfirmationTokenService confirmationTokenService;
    private final static String USER_NOT_FOUND_MSG =
            "user with email %s not found";

    public User addUser(User user) {
        return ur.save(user);
    }

    public User updateUser(User user) {
        return ur.save(user);
    }

    public void deleteUser(Long id) {
        ur.deleteById(id);
    }

    public User getUser(Long id) {
        return ur.findById(id).orElse(null);
    }

    public Set<User> getUsers() {
        return (Set<User>) ur.findAll();
    }

    @Override
    public AtomicInteger getUserbyTypePersonne(Personne personne) {
        AtomicInteger nbrusernatural = new AtomicInteger();
        AtomicInteger Legal_entity = new AtomicInteger();
        ur.findAll().forEach(u -> {
            if (u.getPersonne().equals(Personne.natural_personne)) {
                Legal_entity.addAndGet(1);


            } else {
                nbrusernatural.addAndGet(1);
            }

        });
        if (nbrusernatural.intValue() < Legal_entity.intValue()) {
            return Legal_entity;
        }
        return nbrusernatural;
    }

    public String signUpUser(User user) {
        boolean userExists = ur
                .findByEmail(user.getEmail())
                .isPresent();
        if (userExists) {
            throw new IllegalStateException("email already taken");
        }
        //Role role=roleRepo.findByName("user");
//      System.out.println(role);
        user.setRoles(roleRepo.findByName("user"));
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        ur.save(user);
        String token = UUID.randomUUID().toString();
        ConfirmationToken confirmationToken = new ConfirmationToken(
                token,
                LocalDateTime.now(),
                LocalDateTime.now().plusMinutes(15),
                user
        );
        confirmationTokenService.saveConfirmationToken(
                confirmationToken);
        return token;
    }

    public int enableAppUser(String email) {
        return ur.enableUser(email);
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = ur.findByUsername(username);
        if (user == null) {
            log.info("user not found in database");
            throw new UsernameNotFoundException("user not found in the databse");
        } else {
            log.info("yuser found in the database", username);
        }
        Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
        user.getRoles().forEach(role -> {
            authorities.add(new SimpleGrantedAuthority((role.getName())));
        });
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), authorities);

    }
    public User Completiondeprofil(User user) {
        User user1 = ur.findById(user.getIdUser()).get();
        user1.setAdresse(user.getAdresse());
        user1.setPersonne(user.getPersonne());
        user1.setCin(user.getCin());
        user1.setUsername(user.getUsername());
        user1.setName(user.getName());
        return ur.save(user1);
    }

    public Role saveRole(Role role) {
        return roleRepo.save(role);
    }


}


