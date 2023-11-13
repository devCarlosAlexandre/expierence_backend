package com.xp.expierence.domain.product.dto;

import com.xp.expierence.domain.product.Product;

public record ProdutoDto(String nome, String descricao, String imagem) {
    public ProdutoDto(Product produto) {
        this(produto.getNome(), produto.getDescricao() , produto.getImagem());
    }
}
