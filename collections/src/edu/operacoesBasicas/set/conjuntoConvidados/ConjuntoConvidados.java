package edu.operacoesBasicas.set.conjuntoConvidados;

import java.util.HashSet;
import java.util.Set;

public class ConjuntoConvidados {
    private Set<Convidado> convidadoSet;

    public ConjuntoConvidados() {
        this.convidadoSet = new HashSet<>();
    }

    public void adicionarConvidado(String nome, int codigoConvite) {
        convidadoSet.add(new Convidado(nome, codigoConvite));
    }

    public void removerConvidadoPorCodigoConvite(int codigoConvite) {
        Convidado convidadoParaRemover = null;
        if(!convidadoSet.isEmpty()) {
            for (Convidado c : convidadoSet) {
                if (c.getCodigoConvite() == codigoConvite) {
                    convidadoParaRemover = c;
                    break;
                }
            }
            convidadoSet.remove(convidadoParaRemover);
        } else {
            System.out.println("Lista de convidados vazia");
        }

        if(convidadoParaRemover == null) {
            System.out.println("Convidado nao encontrado");
        }
    }

    public int contarConvidados() {
        return convidadoSet.size();
    }

    public void exibirConvidados() {
        if(!convidadoSet.isEmpty()) {
            System.out.println(convidadoSet);
        } else {
            System.out.println("Lista de convidados vazia");
        }
    }

    public static void main(String[] args) {
        ConjuntoConvidados convidados = new ConjuntoConvidados();

        convidados.adicionarConvidado("Nome1", 1234);
        convidados.adicionarConvidado("Nome2", 1235);
        convidados.adicionarConvidado("Nome3", 1235);
        convidados.adicionarConvidado("Nome4", 1236);

        System.out.println("quantidade de convidados na lista: " + convidados.contarConvidados());
        convidados.exibirConvidados();

        convidados.removerConvidadoPorCodigoConvite(1235);

        System.out.println("quantidade de convidados na lista: " + convidados.contarConvidados());
        convidados.exibirConvidados();
    }
}
