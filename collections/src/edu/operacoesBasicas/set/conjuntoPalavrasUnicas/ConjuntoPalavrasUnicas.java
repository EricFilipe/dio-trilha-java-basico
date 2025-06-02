package edu.operacoesBasicas.set.conjuntoPalavrasUnicas;

import java.util.HashSet;
import java.util.Set;

public class ConjuntoPalavrasUnicas {
    private Set<String> conjuntoPalavras;

    public ConjuntoPalavrasUnicas() {
        this.conjuntoPalavras = new HashSet<>();
    }

    public void adicionarPalavra(String palavra) {
        conjuntoPalavras.add(palavra);
    }

    public void removerPalavra(String palavra) {
        if(!conjuntoPalavras.isEmpty()) {
            if(conjuntoPalavras.contains(palavra)) {
                conjuntoPalavras.remove(palavra);
            } else {
                System.out.println("Palavra nao encontrada no conjunto");
            }
        } else {
            System.out.println("O conjunto de palavras esta vazio");
        }
    }

    public void verificarPalavra(String palavra) {
        if(conjuntoPalavras.contains(palavra)) {
            System.out.println("Sim, a palavra '" + palavra + "' esta presente no conjunto");
        } else {
            System.out.println("Essa palavra nao esta no conjunto");
        }
    }

    public void exibirPalavrasUnicas() {
        if(!conjuntoPalavras.isEmpty()) {
            System.out.println(conjuntoPalavras);
        } else {
            System.out.println("O conjunto de palavras esta vazio");
        }
    }

    public static void main(String[] args) {
        ConjuntoPalavrasUnicas conjuntoPalavrasUnicas = new ConjuntoPalavrasUnicas();

        conjuntoPalavrasUnicas.adicionarPalavra("tomate");
        conjuntoPalavrasUnicas.adicionarPalavra("cenoura");
        conjuntoPalavrasUnicas.adicionarPalavra("alho");
        conjuntoPalavrasUnicas.adicionarPalavra("tomate");
        conjuntoPalavrasUnicas.adicionarPalavra("cebola");

        conjuntoPalavrasUnicas.exibirPalavrasUnicas();

        conjuntoPalavrasUnicas.removerPalavra("alho");

        conjuntoPalavrasUnicas.exibirPalavrasUnicas();

        conjuntoPalavrasUnicas.verificarPalavra("cenoura");
    }
}
