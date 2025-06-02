package edu.ordenacao.list.ordenacaoPessoas;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class OrdenacaoPessoas {
    private List<Pessoa> ordenarPessoas;

    public OrdenacaoPessoas() {
        this.ordenarPessoas = new ArrayList<>();
    }

    public void adicionarPessoa(String nome, int idade, double altura) {
        ordenarPessoas.add(new Pessoa(nome, idade, altura));
    }

    public void ordenarPorIdade() {
        List<Pessoa> pessoasPorIdade = new ArrayList<>(ordenarPessoas);
        Collections.sort(pessoasPorIdade);
        System.out.println(pessoasPorIdade);
    }

    public void ordenarPorAltura() {
        List<Pessoa> pessoasPorAltura = new ArrayList<>(ordenarPessoas);
        Collections.sort(pessoasPorAltura, new CompararAltura());
        System.out.println(pessoasPorAltura);
    }

    public static void main(String[] args) {
        OrdenacaoPessoas ordenacaoPessoas = new OrdenacaoPessoas();

        ordenacaoPessoas.adicionarPessoa("Jose", 22, 1.74);
        ordenacaoPessoas.adicionarPessoa("Welton", 24, 1.68);
        ordenacaoPessoas.adicionarPessoa("Davi", 27, 1.68);
        ordenacaoPessoas.adicionarPessoa("Luiz", 18, 1.78);

        System.out.println("Ordenando pessoas por idade");
        ordenacaoPessoas.ordenarPorIdade();
        System.out.println("Ordenando por altura");
        ordenacaoPessoas.ordenarPorAltura();
    }
}
