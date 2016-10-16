package com.project.messdeck.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.messdeck.entity.Vendor;

public interface VendorRepository extends JpaRepository<Vendor, Long> {

}
