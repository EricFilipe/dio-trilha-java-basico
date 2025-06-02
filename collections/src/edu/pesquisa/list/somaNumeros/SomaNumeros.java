package edu.pesquisa.list.somaNumeros;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SomaNumeros {
    private List<Integer> numeros;

    public SomaNumeros() {
        this.numeros = new ArrayList<>();
    }

    public void adicionarNumero(int numero) {
        numeros.add(numero);
    }

    public int calcularSoma() {
        int valorTotal = 0;
        if(!numeros.isEmpty()) {
            for(Integer n : numeros) {
                valorTotal += n;
            }

            return valorTotal;
        } else {
            throw new RuntimeException();
        }
    }

    public int encontrarMaiorNumero() {
        if(!numeros.isEmpty()) {
            Collections.sort(numeros);
            return numeros.getLast();
        } else {
            throw new RuntimeException();
        }
    }

    public int encontrarMenorNumero() {
        if(!numeros.isEmpty()) {
            Collections.sort(numeros);
            return numeros.getFirst();
        } else {
            throw new RuntimeException();
        }
    }

    public void exibirNumeros() {
        if(!numeros.isEmpty()) {
            System.out.println(numeros);
        } else {
            System.out.println("Lista vazia");
        }
    }


    public static void main(String[] args) {
        SomaNumeros numeros = new SomaNumeros();

        numeros.adicionarNumero(5);
        numeros.adicionarNumero(0);
        numeros.adicionarNumero(0);
        numeros.adicionarNumero(-2);
        numeros.adicionarNumero(10);

        try {
            numeros.exibirNumeros();
            System.out.println("O maior numero e: " + numeros.encontrarMaiorNumero());
            System.out.println("O menor numero e: " + numeros.encontrarMenorNumero());
            System.out.println("A soma dos numeros e: " + numeros.calcularSoma());
        } catch (RuntimeException e) {
            System.out.println("lista vazia");
        }

    }
}
