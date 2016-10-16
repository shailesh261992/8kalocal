package com.project.messdeck.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.messdeck.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
