package com.xp.expierence.domain.review.dto;

public record CreateReviewDto ( String title,String description, Integer rating, String nameUser, Long id_product ) {
}
