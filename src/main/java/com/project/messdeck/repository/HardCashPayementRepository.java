package com.project.messdeck.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.messdeck.entity.HardCashPayment;

public interface HardCashPayementRepository extends JpaRepository<HardCashPayment, Long> {

}
