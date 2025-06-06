package edu.operacoesBasicas.map.dicionario;

import java.util.HashMap;
import java.util.Map;

public class Dicionario {
    private Map<String, String> dicionario;

    public Dicionario() {
        this.dicionario = new HashMap<>();
    }

    public void adicionarPalavra(String palavra, String definicao) {
        dicionario.put(palavra, definicao);
    }

    public void removerPalavra(String palavra) {
        if(!dicionario.isEmpty()) {
            if(!dicionario.containsKey(palavra)) {
                System.out.println("Palavra nao encontrada no dicionario");
            } else {
                dicionario.remove(palavra);
            }
        } else {
            System.out.println("Dicionario vazio");
        }
    }

    public void exibirPalavras() {
        if(!dicionario.isEmpty()) {
            System.out.println(dicionario);
        } else {
            System.out.println("Dicionario vazio");
        }
    }

    public String pesquisarPorPalavra(String palavra) {
        if(!dicionario.isEmpty()) {
            return dicionario.containsKey(palavra) ? dicionario.get(palavra) : "Palavra nao encontrada no dicionario";
        } else {
            throw new RuntimeException();
        }
    }

    @Override
    public String toString() {
        return "{" +
                "dicionario= " + dicionario +
                '}';
    }

    public static void main(String[] args) {
        Dicionario dicionario = new Dicionario();

        dicionario.adicionarPalavra("consisa", "algo que é expressa de forma breve, resumida e precisa");
        dicionario.adicionarPalavra("ombrear", "estar em condições de igualdade");
        dicionario.adicionarPalavra("cornucópia", "Abundância, vaso em forma de chifre cheio de flores e frutos que representa a fartura.");
        dicionario.adicionarPalavra("filantropo", "Altruísta, benevolente.");

        dicionario.exibirPalavras();

        try {
            System.out.println(dicionario.pesquisarPorPalavra("filantropo"));
        } catch (RuntimeException e) {
            System.out.println("Dicionario vazio");
        }

        dicionario.removerPalavra("cornucópia");

        dicionario.exibirPalavras();
    }
}
