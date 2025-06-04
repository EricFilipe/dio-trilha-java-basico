package edu.ordenacao.set.cadastroProdutos;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class CadastroProdutos {
    private Set<Produto> listaProdutos;

    public CadastroProdutos() {
        this.listaProdutos = new HashSet<>();
    }

    public void adicionarProduto(long cod, String nome, double preco, int quantidade) {
        listaProdutos.add(new Produto(cod, nome, preco, quantidade));
    }

    public Set<Produto> exibirProdutosPorNome() {
        if(!listaProdutos.isEmpty()) {
            Set<Produto> produtosPorNome = new TreeSet<>(listaProdutos);
            return produtosPorNome;
        } else {
            throw new RuntimeException();
        }
    }

    public Set<Produto> exibirProdutosPorPreco() {
        if(!listaProdutos.isEmpty()) {
            Set<Produto> produtosPorPreco = new TreeSet<>(new ComparatorPorPreco());
            produtosPorPreco.addAll(listaProdutos);
            return produtosPorPreco;
        } else {
            throw new RuntimeException();
        }
    }

    public static void main(String[] args) {
        CadastroProdutos produtos = new CadastroProdutos();

        produtos.adicionarProduto(1, "caderno", 3.99, 4);
        produtos.adicionarProduto(2, "borracha", 4.19, 7);
        produtos.adicionarProduto(1, "lapis", 1.50, 3);
        produtos.adicionarProduto(3, "caneta", 4.50, 11);
        produtos.adicionarProduto(4, "tesoura", 6.00, 5);

        System.out.println(produtos.listaProdutos);
        try {
            System.out.println(produtos.exibirProdutosPorNome());

            System.out.println(produtos.exibirProdutosPorPreco());
        } catch (RuntimeException e) {
            System.out.println("Lista de produtos vazia");
        }
    }
}
