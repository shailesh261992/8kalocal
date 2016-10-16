package com.project.messdeck.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.messdeck.entity.Owner;

public interface OwnerRepository extends JpaRepository<Owner, Long> {

}
