package com.uhcl.amazonsellers.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.uhcl.amazonsellers.domain.Review;

public interface ReviewRepository extends JpaRepository<Review,Long> {

}
