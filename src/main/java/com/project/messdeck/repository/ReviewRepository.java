package com.project.messdeck.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.messdeck.entity.Review;

public interface ReviewRepository extends JpaRepository<Review, Long> {

}
