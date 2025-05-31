package edu.ordenacaoEmList.ordenacaoNumeros;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class OrdenacaoNumeros {
    private List<Integer> numeros;

    public OrdenacaoNumeros() {
        this.numeros = new ArrayList<>();
    }

    public void adicionarNumero(int numero) {
        numeros.add(numero);
    }

    public List<Integer> ordenarAscendente() {
        List<Integer> numerosAscendentes = new ArrayList<>(numeros);
        if(!numeros.isEmpty()) {
            Collections.sort(numerosAscendentes);
            return numerosAscendentes;
        } else {
            throw new RuntimeException();
        }
    }

    public List<Integer> ordenarDescendente() {
        List<Integer> numerosAscendentes = new ArrayList<>(numeros);
        if(!numeros.isEmpty()) {
            numerosAscendentes.sort(Collections.reverseOrder());
            return numerosAscendentes;
        } else {
            throw new RuntimeException();
        }
    }

    @Override
    public String toString() {
        return "numeros = " + numeros +
                '}';
    }

    public static void main(String[] args) {
        OrdenacaoNumeros numeros = new OrdenacaoNumeros();

        numeros.adicionarNumero(4);
        numeros.adicionarNumero(56);
        numeros.adicionarNumero(456);
        numeros.adicionarNumero(23);
        numeros.adicionarNumero(7);

        try {
            System.out.println(numeros.numeros);
            System.out.println(numeros.ordenarAscendente());
            System.out.println(numeros.ordenarDescendente());
        } catch (RuntimeException e) {
            System.out.println("A lista esta vazia");
        }
    }
}


