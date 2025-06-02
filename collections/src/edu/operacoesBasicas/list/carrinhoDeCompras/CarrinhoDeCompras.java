package edu.operacoesBasicas.list.carrinhoDeCompras;

import java.util.ArrayList;
import java.util.List;

public class CarrinhoDeCompras {
    private List<Item> carrinho;

    public CarrinhoDeCompras() {
        this.carrinho = new ArrayList<>();
    }

    public void adicinarItem(String nome, double preco, int quantidade) {
        carrinho.add(new Item(nome, preco, quantidade));
    }

    public void removerItem(String nome) {
        List<Item> itensParaRemover = new ArrayList<>();
        if(!carrinho.isEmpty()) {
            for (Item item : carrinho) {
                if (item.getNome().equalsIgnoreCase(nome)) {
                    itensParaRemover.add(item);
                }
            }
            carrinho.removeAll(itensParaRemover);
        } else {
            System.out.println("A lista está vazia");
        }
    }

    public double calcularValorTotal() {
        double valorTotal = 0;
        if(!carrinho.isEmpty()) {
            for (Item item : carrinho) {
                double valorItem = item.getPreco() * item.getQuantidade();
                valorTotal += valorItem;
            }
            return valorTotal;
        } else {
            throw new RuntimeException();
        }
    }

    public void exibirItens() {
        if(!carrinho.isEmpty()) {
            for (Item item : carrinho) {
                System.out.println("Nome: " + item.getNome() + ", Preço: " + item.getPreco() + ", Quantidade: " + item.getQuantidade());
            }
        } else {
            System.out.println("A lista está vazia");
        }
    }

    public static void main(String[] args) {
        System.out.println("=======Carrinho de compras=======");

        CarrinhoDeCompras carrinhoDeCompras = new CarrinhoDeCompras();

        carrinhoDeCompras.adicinarItem("Lapis", 3.00, 1);
        carrinhoDeCompras.adicinarItem("Caneta", 2.00, 5);
        carrinhoDeCompras.adicinarItem("borracha", 1.99, 2);
        carrinhoDeCompras.adicinarItem("Caderno", 14.99, 1);

        try {
            carrinhoDeCompras.exibirItens();
            double valorTotal = carrinhoDeCompras.calcularValorTotal();
            System.out.println("Valor total do carrinho: " + valorTotal);
            System.out.println("-----------------------");
            carrinhoDeCompras.removerItem("borracha");
            carrinhoDeCompras.exibirItens();
            valorTotal = carrinhoDeCompras.calcularValorTotal();
            System.out.println("Valor total do carrinho: " + valorTotal);
        } catch (RuntimeException e) {
            System.out.println("A lista esta vazia");
        }
    }
}
