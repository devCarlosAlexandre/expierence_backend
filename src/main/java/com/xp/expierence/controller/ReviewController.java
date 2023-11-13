package com.xp.expierence.controller;

import com.xp.expierence.domain.product.ProductRepository;
import com.xp.expierence.domain.product.dto.ProdutoDto;
import com.xp.expierence.domain.review.Review;
import com.xp.expierence.domain.review.ReviewRepository;
import com.xp.expierence.domain.review.dto.CreateReviewDto;
import com.xp.expierence.domain.review.dto.ReviewDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/review")
public class ReviewController {
    @Autowired
    ProductRepository productRepository;
    @Autowired
    ReviewRepository repository;

    @PostMapping()
    @Transactional()
    public ResponseEntity createReview(@RequestBody() CreateReviewDto reviewDto){

        var produto = productRepository.getReferenceById(reviewDto.id_product());

        if(produto.getId() == null){
            return ResponseEntity.badRequest().build();
        }
        var review = new Review(reviewDto, produto);
        var reviewCreated = repository.save(review);

        if(reviewCreated == null){
            return ResponseEntity.badRequest().build();
        }

        return ResponseEntity.ok(new ReviewDto(reviewCreated));
    }
}
