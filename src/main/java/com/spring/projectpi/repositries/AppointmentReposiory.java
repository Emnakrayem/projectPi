package com.spring.projectpi.repositries;

import com.spring.projectpi.entites.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppointmentReposiory extends CrudRepository<Appointment,Long> {
}
