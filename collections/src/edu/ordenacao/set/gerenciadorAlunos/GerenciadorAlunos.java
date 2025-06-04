package edu.ordenacao.set.gerenciadorAlunos;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class GerenciadorAlunos {
    private Set<Aluno> listaAlunos;

    public GerenciadorAlunos() {
        this.listaAlunos = new HashSet<>();
    }

    public void adicionarAluno(String nome, long matricula, double nota) {
        listaAlunos.add(new Aluno(nome, matricula, nota));
    }

    public void removerAluno(long matricula) {
        if(!listaAlunos.isEmpty()) {
            Aluno alunoParaRemover = null;
            for(Aluno a : listaAlunos) {
                if(a.getMatricula() == matricula) {
                    alunoParaRemover = a;
                    break;
                }
            }
            listaAlunos.remove(alunoParaRemover);

            if(alunoParaRemover == null) {
                System.out.println("Aluno nao encontrado na lista");
            }
        } else {
            System.out.println("Lista de alunos vazia");
        }
    }

    public void exibirAlunosPorNome() {
        if(!listaAlunos.isEmpty()) {
            Set<Aluno> alunosPorNome = new TreeSet<>(listaAlunos);
            System.out.println(alunosPorNome);
        } else {
            System.out.println("Lista de alunos vazia");
        }
    }

    public void exibirAlunosPorNota() {
        if(!listaAlunos.isEmpty()) {
            Set<Aluno> alunosPorNota = new TreeSet<>(new ComparatorPorNota());
            alunosPorNota.addAll(listaAlunos);
            System.out.println(alunosPorNota);
        } else {
            System.out.println("Lista de alunos vazia");
        }
    }

    public void exibirAlunos() {
        if(!listaAlunos.isEmpty()) {
            System.out.println(listaAlunos);
        } else {
            System.out.println("Lista vazia");
        }
    }

    public static void main(String[] args) {
        GerenciadorAlunos gerenciadorAlunos = new GerenciadorAlunos();

        gerenciadorAlunos.adicionarAluno("Jose Alberto", 201, 8.2);
        gerenciadorAlunos.adicionarAluno("Carlos", 202, 8.0);
        gerenciadorAlunos.adicionarAluno("Pedro", 203, 7.6);
        gerenciadorAlunos.adicionarAluno("Wendel", 202, 7.6);
        gerenciadorAlunos.adicionarAluno("Carlos Santos", 204, 9.0);

        gerenciadorAlunos.exibirAlunos();


        gerenciadorAlunos.exibirAlunosPorNome();

        gerenciadorAlunos.exibirAlunosPorNota();

        gerenciadorAlunos.removerAluno(202);

        gerenciadorAlunos.exibirAlunos();
    }
}
