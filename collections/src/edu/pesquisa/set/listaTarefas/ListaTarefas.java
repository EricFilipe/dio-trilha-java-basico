package edu.pesquisa.set.listaTarefas;

import java.util.HashSet;
import java.util.Set;

public class ListaTarefas {
    private Set<Tarefa> listaTarefa;

    public ListaTarefas() {
        this.listaTarefa = new HashSet<>();
    }

    public void adicionarTarefa(String descricao) {
        listaTarefa.add(new Tarefa(descricao));
    }

    public void removerTarefa(String descricao) {
        Tarefa tarefaParaRemover = null;
        if(!listaTarefa.isEmpty()) {
            for(Tarefa t : listaTarefa) {
                if(t.getDescricao().equalsIgnoreCase(descricao)) {
                    tarefaParaRemover = t;
                    break;
                }
            }
            listaTarefa.remove(tarefaParaRemover);
        } else {
            System.out.println("Lista de tarefas vazia");
        }

        if(tarefaParaRemover == null) {
            System.out.println("Tarefa nao encontrada");
        }
    }

    public void exibirTarefas() {
        if(!listaTarefa.isEmpty()) {
            System.out.println(listaTarefa);
        } else {
            System.out.println("Lista de tarefas vazia");
        }
    }

    public int contarTarefas() {
        return listaTarefa.size();
    }

    public void marcarTarefaConcluida(String descricao) {
        if(!listaTarefa.isEmpty()) {
            for(Tarefa t : listaTarefa) {
                if(t.getDescricao().equalsIgnoreCase(descricao)) {
                    t.setConcluidaOuPendente(true);
                }
            }
        } else {
            System.out.println("Lista de tarefas vazia");
        }
    }

    public void marcarTarefaPendente(String descricao) {
        if(!listaTarefa.isEmpty()) {
            for(Tarefa t : listaTarefa) {
                if(t.getDescricao().equalsIgnoreCase(descricao)) {
                    t.setConcluidaOuPendente(false);
                }
            }
        } else {
            System.out.println("Lista de tarefas vazia");
        }
    }

    public Set<Tarefa> obterTarefasConcluidas() {
        if(!listaTarefa.isEmpty()) {
            Set<Tarefa> tarefasConcluidas = new HashSet<>();
            for(Tarefa t : listaTarefa) {
                if(t.isConcluidaOuPendente()) {
                    tarefasConcluidas.add(t);
                }
            }
            return tarefasConcluidas;
        } else {
            throw new RuntimeException();
        }
    }

    public Set<Tarefa> obterTarefasPendentes() {
        if(!listaTarefa.isEmpty()) {
            Set<Tarefa> tarefasPendentes = new HashSet<>();
            for(Tarefa t : listaTarefa) {
                if(!t.isConcluidaOuPendente()) {
                    tarefasPendentes.add(t);
                }
            }
            return tarefasPendentes;
        } else {
            throw new RuntimeException();
        }
    }

    public void limparListaTarefas() {
        if(listaTarefa.isEmpty()) {
            System.out.println("A lista ja esta vazia");
        } else {
            listaTarefa.clear();
        }
    }

    public static void main(String[] args) {
        ListaTarefas listaTarefas = new ListaTarefas();

        listaTarefas.adicionarTarefa("estudar");
        listaTarefas.adicionarTarefa("ler");
        listaTarefas.adicionarTarefa("treinar");
        listaTarefas.adicionarTarefa("assistir");
        listaTarefas.adicionarTarefa("limpar o quarto");

        System.out.println("O numero de tarefas e: " + listaTarefas.contarTarefas());
        listaTarefas.exibirTarefas();

        listaTarefas.removerTarefa("limpar o quarto");

        System.out.println("O numero de tarefas e: " + listaTarefas.contarTarefas());
        listaTarefas.exibirTarefas();

        listaTarefas.marcarTarefaConcluida("Estudar");
        listaTarefas.marcarTarefaConcluida("treinar");
        listaTarefas.marcarTarefaConcluida("assistir");

        try {
            System.out.println("====Tarefas concluidas====");
            System.out.println(listaTarefas.obterTarefasConcluidas());

            System.out.println("====Tarefas pendentes====");
            System.out.println(listaTarefas.obterTarefasPendentes());
        } catch (RuntimeException e) {
            System.out.println("Lista de tarefas vazia");
        }

        listaTarefas.limparListaTarefas();
        listaTarefas.exibirTarefas();
    }
}
