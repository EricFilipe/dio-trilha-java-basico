package edu.pesquisa.set.listaTarefas;

public class Tarefa {
    private String descricao;
    private boolean concluidaOuPendente;

    public Tarefa(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

    public boolean isConcluidaOuPendente() {
        return concluidaOuPendente;
    }

    public void setConcluidaOuPendente(boolean concluidaOuPendente) {
        this.concluidaOuPendente = concluidaOuPendente;
    }

    @Override
    public String toString() {
        return
                "'" + descricao + '\'' ;
    }
}
