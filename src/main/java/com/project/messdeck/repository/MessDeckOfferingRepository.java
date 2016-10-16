package com.project.messdeck.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.messdeck.entity.MessDeckOffering;

public interface MessDeckOfferingRepository extends JpaRepository<MessDeckOffering, Long> {

}
