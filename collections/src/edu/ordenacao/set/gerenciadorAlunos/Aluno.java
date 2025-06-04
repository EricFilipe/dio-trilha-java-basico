package edu.ordenacao.set.gerenciadorAlunos;

import java.util.Comparator;
import java.util.Objects;

public class Aluno implements Comparable<Aluno> {
    private String nome;
    private long matricula;
    private double nota;

    public Aluno(String nome, long matricula, double nota) {
        this.nome = nome;
        this.matricula = matricula;
        this.nota = nota;
    }

    public String getNome() {
        return nome;
    }

    public long getMatricula() {
        return matricula;
    }

    public double getNota() {
        return nota;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Aluno alunos = (Aluno) o;
        return matricula == alunos.matricula;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(matricula);
    }

    @Override
    public String toString() {
        return "{" +
                "nome='" + nome + '\'' +
                ", matricula=" + matricula +
                ", nota=" + nota +
                '}';
    }

    @Override
    public int compareTo(Aluno a) {
        return nome.compareToIgnoreCase(a.getNome());
    }
}


class ComparatorPorNota implements Comparator<Aluno> {

    @Override
    public int compare(Aluno a1, Aluno a2) {
        return Double.compare(a1.getNota(), a2.getNota());
    }
}