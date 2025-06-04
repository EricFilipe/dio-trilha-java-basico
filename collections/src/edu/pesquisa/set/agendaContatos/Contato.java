package edu.pesquisa.set.agendaContatos;

import java.util.Objects;

public class Contato {
    private String nome;
    private int numeroTelefone;

    public Contato(String nome, int numeroTelefone) {
        this.nome = nome;
        this.numeroTelefone = numeroTelefone;
    }

    public String getNome() {
        return nome;
    }

    public int getNumeroTelefone() {
        return numeroTelefone;
    }

    public void setNumeroTelefone(int numeroTelefone) {
        this.numeroTelefone = numeroTelefone;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Contato contato = (Contato) o;
        return numeroTelefone == contato.numeroTelefone;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(numeroTelefone);
    }

    @Override
    public String toString() {
        return '{' + nome + ',' + numeroTelefone + '}';
    }
}
