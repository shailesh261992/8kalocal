package com.project.messdeck.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.messdeck.entity.Item;

public interface ItemRepository extends JpaRepository<Item, Long> {

}
