package com.project.messdeck.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.messdeck.entity.VendorItem;

public interface VendorItemRepository extends JpaRepository<VendorItem, Long> {

}
