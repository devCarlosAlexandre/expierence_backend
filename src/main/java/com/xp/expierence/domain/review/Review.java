package com.xp.expierence.domain.review;

import com.xp.expierence.domain.product.Product;
import com.xp.expierence.domain.review.dto.CreateReviewDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity(name = "reviews")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String description;

    private Integer rating;

    private String nameUser;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Product product;

    public Review(CreateReviewDto reviewDto, Product product) {
        this.description = reviewDto.description();
        this.title = reviewDto.title();
        this.nameUser = reviewDto.nameUser();
        this.rating = reviewDto.rating();
        this.product = product;
    }
}
