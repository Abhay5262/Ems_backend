package com.ems.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ems.entities.Emp_Entity;
@Repository
public interface Emp_repo extends JpaRepository<Emp_Entity, Long> {

}
