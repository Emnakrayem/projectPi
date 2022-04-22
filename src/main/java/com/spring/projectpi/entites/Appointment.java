package com.spring.projectpi.entites;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAppoitment;
    @Temporal(TemporalType.TIMESTAMP)
     Date dateAppoitment;
    public Appointment(Date dateAppoitment, User user ){
        this.user=user;
        this.dateAppoitment=dateAppoitment;

    }
    @ManyToOne
    Agency agency;
    @ManyToOne
    User user;
}
