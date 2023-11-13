package com.xp.expierence.domain.product.dto;

import com.xp.expierence.domain.product.Product;
import com.xp.expierence.domain.review.Review;
import com.xp.expierence.domain.review.dto.ReviewDto;

import java.util.List;
import java.util.stream.Stream;

public record ProdutoDtoDetails(String nome, String descricao, String imagem, Stream<ReviewDto> reviews) {

    public ProdutoDtoDetails(Product produto, Stream<ReviewDto> reviews){
        this(produto.getNome(), produto.getDescricao(), produto.getImagem(), reviews );
    }
}
