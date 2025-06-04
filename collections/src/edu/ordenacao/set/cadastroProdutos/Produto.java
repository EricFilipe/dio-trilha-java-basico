package edu.ordenacao.set.cadastroProdutos;

import java.util.Objects;

public class Produto {
    private long cod;
    private String nome;
    private double preco;
    private int quatidade;

    public Produto(long cod, String nome, double preco, int quatidade) {
        this.cod = cod;
        this.nome = nome;
        this.preco = preco;
        this.quatidade = quatidade;
    }

    public long getCod() {
        return cod;
    }

    public String getNome() {
        return nome;
    }

    public double getPreco() {
        return preco;
    }

    public int getQuatidade() {
        return quatidade;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Produto produto = (Produto) o;
        return cod == produto.cod;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(cod);
    }

    @Override
    public String toString() {
        return "Produto{" +
                "cod = " + cod +
                ", nome = '" + nome + '\'' +
                ", preco = " + preco +
                ", quatidade = " + quatidade +
                '}';
    }
}
