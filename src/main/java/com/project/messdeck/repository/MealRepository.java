package com.project.messdeck.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.messdeck.entity.Meal;

public interface MealRepository extends JpaRepository<Meal, Long> {

}
