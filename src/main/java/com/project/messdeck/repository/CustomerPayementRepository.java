package com.project.messdeck.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.messdeck.entity.CustomerPayement;

public interface CustomerPayementRepository extends JpaRepository<CustomerPayement, Long> {

}
