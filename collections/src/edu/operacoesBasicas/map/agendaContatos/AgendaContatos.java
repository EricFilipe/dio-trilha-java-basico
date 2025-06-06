package edu.operacoesBasicas.map.agendaContatos;

import java.util.HashMap;
import java.util.Map;

public class AgendaContatos {
    private Map<String, Integer> contatos;

    public AgendaContatos() {
        this.contatos = new HashMap<>();
    }

    public void adicionarContato(String nome, Integer telefone) {
        contatos.put(nome, telefone);
    }

    public void removerContato(String nome) {
        if(!contatos.isEmpty()) {
            if(contatos.containsKey(nome)) {
                contatos.remove(nome);
            } else {
                System.out.println("Nome nao encontrado na lista de contatos");
            }
        } else {
            System.out.println("Lista de contatos vazia");
        }
    }

    public void exibirContatos() {
        if(!contatos.isEmpty()) {
            System.out.println(contatos);
        } else {
            System.out.println("Lista vazia, nenhum contato para exibir");
        }
    }

    public Integer pesquisarPorNome(String nome) {
        Integer numeroPorNome = null;
        if(!contatos.isEmpty()) {
          numeroPorNome = contatos.get(nome);
          if (numeroPorNome == null) {
              System.out.println("Contato nao encontrado na lista");
          }
        } else {
            System.out.println("Lista de contatos vazia");
        }
        return numeroPorNome;
    }

    @Override
    public String toString() {
        return "{" +
                "contatos=" + contatos +
                '}';
    }

    public static void main(String[] args) {
        AgendaContatos contatos = new AgendaContatos();

        contatos.adicionarContato("Camila" , 443);
        contatos.adicionarContato("Maria" , 441);
        contatos.adicionarContato("Joao" , 446);
        contatos.adicionarContato("Maria" , 448);
        contatos.adicionarContato("Bruno" , 449);

        contatos.exibirContatos();

        System.out.println(contatos.pesquisarPorNome("bruno"));

        contatos.removerContato("Maria");

        contatos.exibirContatos();
    }
}
