package edu.pesquisa.map.estoqueProdutos;

import java.util.HashMap;
import java.util.Map;

public class EstoqueProdutos {
    private Map<Long, Produto> estoqueProduto;

    public EstoqueProdutos() {
        this.estoqueProduto = new HashMap<>();
    }

    public void adicionarProduto(long cod, String nome, int quantidade, double preco) {
        estoqueProduto.put(cod, new Produto(nome, quantidade, preco));
    }

    public void exibirProdutos() {
        if(!estoqueProduto.isEmpty()) {
            System.out.println(estoqueProduto);
        } else {
            System.out.println("Estoque vazio");
        }
    }

    public double calcularValorTotalEstoque() {
        double valorTotal = 0;
        if(!estoqueProduto.isEmpty()) {
            for(Produto p : estoqueProduto.values()) {
                valorTotal += p.getPreco() * p.getQuantidade();
            }
        }
        return valorTotal;
    }

    public Produto obterProdutoMaisCaro() {
        if(!estoqueProduto.isEmpty()) {
            Produto produtoMaisCaro = null;
            double valorMaisAlto = Double.MIN_VALUE;
            for(Produto p : estoqueProduto.values()) {
                if (p.getPreco() > valorMaisAlto) {
                    valorMaisAlto = p.getPreco();
                    if (p.getPreco() == valorMaisAlto) {
                        produtoMaisCaro = p;
                    }
                }
            }
            return produtoMaisCaro;
        } else {
            throw new RuntimeException();
        }
    }

    public Produto obterProdutoMaisBarato() {
        if(!estoqueProduto.isEmpty()) {
            Produto produtoMaisBarato = null;
            double valorMaisBaixo = Double.MAX_VALUE;
            for(Produto p : estoqueProduto.values()) {
                if (p.getPreco() < valorMaisBaixo) {
                    valorMaisBaixo = p.getPreco();
                    if (p.getPreco() == valorMaisBaixo) {
                        produtoMaisBarato = p;
                    }
                }
            }
            return produtoMaisBarato;
        } else {
            throw new RuntimeException();
        }
    }

    public Produto obterProdutoMaiorQuantidadeValorTotalNoEstoque() {
        if(!estoqueProduto.isEmpty()) {
            Produto produtoMaiorQuantidadeValorTotal = null;
            double compararValorTotalProduto = 0;
            for(Produto p : estoqueProduto.values()) {
                double valorTotalProduto = p.getPreco() * p.getQuantidade();
                if(valorTotalProduto > compararValorTotalProduto) {
                    produtoMaiorQuantidadeValorTotal = p;
                    compararValorTotalProduto = valorTotalProduto;
                }
            }
            return produtoMaiorQuantidadeValorTotal;
        } else {
            throw new RuntimeException();
        }
    }

    public static void main(String[] args) {
        EstoqueProdutos estoqueProdutos = new EstoqueProdutos();

        estoqueProdutos.adicionarProduto(1, "Produto A", 3, 7.0);
        estoqueProdutos.adicionarProduto(2, "Produto B", 9, 5.0);
        estoqueProdutos.adicionarProduto(3, "Produto C", 2, 10.0);
        estoqueProdutos.adicionarProduto(4, "Produto D", 7, 7.0);

        estoqueProdutos.exibirProdutos();

        System.out.println("Valor total estoque: " + estoqueProdutos.calcularValorTotalEstoque());

        try {
            System.out.println("Produto mais caro: " + estoqueProdutos.obterProdutoMaisCaro());

            System.out.println("Produto mais barato: " + estoqueProdutos.obterProdutoMaisBarato());

            System.out.println("Produto que está em maior quantidade no estoque, considerando o valor total de cada produto: " + estoqueProdutos.obterProdutoMaiorQuantidadeValorTotalNoEstoque());
        } catch (RuntimeException e) {
            System.out.println("Estoque vazio");
        }
    }
}
