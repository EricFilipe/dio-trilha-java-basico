package edu.ordenacao.set.cadastroProdutos;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class CadastroProdutos {
    private Set<Produto> listaProdutos;

    public CadastroProdutos() {
        this.listaProdutos = new HashSet<>();
    }

    public void adicionarProduto(long cod, String nome, double preco, int quantidade) {
        listaProdutos.add(new Produto(cod, nome, preco, quantidade));
    }

    public void exibirProdutosPorNome() {

    }
}
