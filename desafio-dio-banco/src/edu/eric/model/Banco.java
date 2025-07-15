package edu.eric.model;

import java.util.ArrayList;
import java.util.List;

public class Banco {
    private String nome;
    private List<Conta> contas;

    public Banco(String nome) {
        this.nome = nome;
        this.contas = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public void adicionarConta(Conta conta) {
        contas.add(conta);
    }

    public void getContas() {
        if(!contas.isEmpty()) {
            contas.forEach(System.out::println);
        } else {
            System.out.println("Lista de contas vazia");
        }
    }

    public void exibirClientes() {
        if(!contas.isEmpty()) {
            contas.stream().map(c -> c.cliente.getNome()).forEach(System.out::println);
        } else {
            System.out.println("Lista de contas vazia");
        }
    }

    public void limparLista() {
        if(!contas.isEmpty()){
            contas.clear();
        } else {
            System.out.println("Lista de contas ja esta vazia");
        }
    }
}
