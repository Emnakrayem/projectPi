package com.spring.projectpi.entites;

import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUser;
    private String name;
    private String prenom;
    private String username;
    private String adresse;
    private String nationalite;
    private String email;
    private Boolean isBlocked;
    private Boolean enabled =false;
    String password;
    Long phone;
    Long cin;
    @Temporal(TemporalType.DATE)
     Date dateDeNaissance;
    @ManyToMany(fetch = FetchType.EAGER)
    private List<Role> roles;
    @Enumerated(EnumType.STRING)
    Personne personne;
    @ManyToMany(mappedBy ="users")
    Set<Agency> agencies;
}
