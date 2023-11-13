package com.xp.expierence.domain.review;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReviewRepository extends JpaRepository<Review, Long> {
    public List<Review> findAllByProductId(Long id);
}
