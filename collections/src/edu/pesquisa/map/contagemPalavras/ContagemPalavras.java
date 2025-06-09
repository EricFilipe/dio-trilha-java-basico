package edu.pesquisa.map.contagemPalavras;

import java.util.HashMap;
import java.util.Map;

public class ContagemPalavras {
    private Map<String, Integer> contarPalavras;

    public ContagemPalavras() {
        this.contarPalavras = new HashMap<>();
    }

    public void adicionarPalavra(String palavra, Integer contagem) {
        contarPalavras.put(palavra, contagem);
    }

    public void removerPalavra(String palavra) {
        if(!contarPalavras.isEmpty()) {
            if(contarPalavras.containsKey(palavra)) {
                contarPalavras.remove(palavra);
            } else {
                System.out.println("Palavra nao encontrada");
            }
        } else {
            System.out.println("Lista de palavras vazia");
        }
    }

    public void exibirContagemPalavras() {
        if(!contarPalavras.isEmpty()) {
            System.out.println(contarPalavras);
        } else {
            System.out.println("Lista de palavras vazia");
        }
    }

    public void encontrarPalavraMaisFrequente() {
        if(!contarPalavras.isEmpty()) {
            Map<String, Integer> palavraMaisFrequente = new HashMap<>();
            String palavra = "";
            int valorMaisAlto = 0;
            for(Map.Entry<String, Integer> p : contarPalavras.entrySet()) {
                if(p.getValue() > valorMaisAlto) {
                    valorMaisAlto = p.getValue();
                    palavra = p.getKey();
                }
            }
            palavraMaisFrequente.put(palavra, valorMaisAlto);
            System.out.println(palavraMaisFrequente);
        } else {
            System.out.println("Lista de palavras vazia");
        }
    }

    public static void main(String[] args) {
        ContagemPalavras contagemLinguagens = new ContagemPalavras();

        contagemLinguagens.adicionarPalavra("Java", 2);
        contagemLinguagens.adicionarPalavra("Python", 8);
        contagemLinguagens.adicionarPalavra("JavaScript", 1);
        contagemLinguagens.adicionarPalavra("C#", 6);

        contagemLinguagens.exibirContagemPalavras();

        contagemLinguagens.encontrarPalavraMaisFrequente();
    }
}
