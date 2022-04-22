package com.spring.projectpi.entites;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Agency {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAgence;
    String adresse;
    String name;
    Long phone;
    String email;
    @ManyToMany
    Set<User> users;

}
