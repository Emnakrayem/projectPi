package com.spring.projectpi.repositries;

import com.spring.projectpi.entites.Agency;
import com.spring.projectpi.entites.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AgencyReposiory extends CrudRepository<Agency,Long> {
}
