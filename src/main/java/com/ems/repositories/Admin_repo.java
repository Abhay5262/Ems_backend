package com.ems.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ems.entities.Administrator_Entity;
@Repository
public interface Admin_repo extends JpaRepository<Administrator_Entity, Long> {

}
