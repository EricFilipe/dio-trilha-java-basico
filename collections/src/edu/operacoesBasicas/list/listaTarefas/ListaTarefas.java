package edu.operacoesBasicas.list.listaTarefas;

import java.util.ArrayList;
import java.util.List;

public class ListaTarefas {
    private List<Tarefa> listaTarefa;

    public ListaTarefas() {
        this.listaTarefa = new ArrayList<>();
    }

    public void adicionarTarefa(String descricao) {
        listaTarefa.add(new Tarefa(descricao));
    }

    public void removerTarefa(String descricao) {
        List<Tarefa> tarefasParaRemover = new ArrayList<>();
        if(!listaTarefa.isEmpty()) {
            for (Tarefa tarefa : listaTarefa) {
                if (tarefa.getDescricao().equalsIgnoreCase(descricao)) {
                    tarefasParaRemover.add(tarefa);
                }
            }
            listaTarefa.removeAll(tarefasParaRemover);
        } else {
            System.out.println("A lista está vazia");
        }
    }

    public void obterNumeroTotalTarefas() {
        System.out.println("NUmero de tarefas na lista: " + listaTarefa.size());
    }

    public void obterDescricoesTarefas() {
        if(!listaTarefa.isEmpty()) {
            System.out.println(listaTarefa);
        } else {
            System.out.println("A lista está vazia");
        }
    }

    public static void main(String[] args) {
        ListaTarefas listaTarefas = new ListaTarefas();

        System.out.println("=======Lista de tarefas=======");

        listaTarefas.adicionarTarefa("ir pra academia");
        listaTarefas.adicionarTarefa("estudar");
        listaTarefas.adicionarTarefa("ler");
        listaTarefas.adicionarTarefa("assistir");

        listaTarefas.obterNumeroTotalTarefas();
        listaTarefas.obterDescricoesTarefas();
        System.out.println("--------------------");
        listaTarefas.removerTarefa("assistir");
        listaTarefas.obterNumeroTotalTarefas();
        listaTarefas.obterDescricoesTarefas();
    }
}
