package com.project.messdeck.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.messdeck.entity.MealItem;
import com.project.messdeck.entity.VendorItem;

public interface MealItemRepository extends JpaRepository<MealItem, Long> {

	public MealItem findByVendorItemAndCount(VendorItem vitem, int count);

}
