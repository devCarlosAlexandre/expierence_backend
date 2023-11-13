package com.xp.expierence.domain.review.dto;

import com.xp.expierence.domain.review.Review;


public record ReviewDto( Long id,  String title, String description, Integer rating, String nameUser,Long product_id) {

    public ReviewDto(Review reviewCreated){
        this(reviewCreated.getId(), reviewCreated.getTitle(), reviewCreated.getDescription(), reviewCreated.getRating(), reviewCreated.getNameUser(), reviewCreated.getProduct().getId());
    }

}
