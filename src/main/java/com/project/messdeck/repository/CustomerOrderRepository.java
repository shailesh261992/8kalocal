package com.project.messdeck.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.messdeck.entity.CustomerOrder;

public interface CustomerOrderRepository extends JpaRepository<CustomerOrder, Long> {

}
