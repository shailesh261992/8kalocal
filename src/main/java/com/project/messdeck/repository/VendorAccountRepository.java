package com.project.messdeck.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.messdeck.entity.VendorAccount;

public interface VendorAccountRepository extends JpaRepository<VendorAccount, Long> {

}
