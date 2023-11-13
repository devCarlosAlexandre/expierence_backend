package com.xp.expierence.controller;

import com.xp.expierence.domain.product.ProductRepository;
import com.xp.expierence.domain.product.dto.ProdutoDto;
import com.xp.expierence.domain.product.dto.ProdutoDtoDetails;
import com.xp.expierence.domain.review.ReviewRepository;
import com.xp.expierence.domain.review.dto.ReviewDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/produtos")
public class ProductController {
    @Autowired
    ProductRepository repository;

    @Autowired
    ReviewRepository reviewRepository;

    @GetMapping
    public ResponseEntity getAllProducts(){
        var produtos = repository.findAll();
        return ResponseEntity.ok(produtos);
    }

    @GetMapping("/{id}")
    @Transactional()
    public ResponseEntity getByIdProduct(@PathVariable() Long id){
        var produto  = repository.getReferenceById(id);
        if(produto.getId() == null){
            return ResponseEntity.notFound().build();
        }

        var reviews = reviewRepository.findAllByProductId(produto.getId()).stream().map(ReviewDto::new);

        var produtoDtoDetails = new ProdutoDtoDetails(produto, reviews);

        return ResponseEntity.ok(produtoDtoDetails);
    }


}
