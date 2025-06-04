package edu.pesquisa.set.agendaContatos;

import java.util.HashSet;
import java.util.Set;

public class AgendaContatos {
    private Set<Contato> contatos;

    public AgendaContatos() {
        this.contatos = new HashSet<>();
    }

    public void adicionarContato(String nome, int numero) {
        contatos.add(new Contato(nome, numero));
    }

    public void exibirContatos() {
        if(!contatos.isEmpty()) {
            System.out.println(contatos);
        } else {
            System.out.println("Lista de contatos vazia");
        }
    }

    public Set<Contato> pesquisarPorNome(String nome) {
        Set<Contato> contatoPorNome = new HashSet<>();
        if(!contatos.isEmpty()){
            for (Contato c : contatos) {
                if(c.getNome().startsWith(nome)) {
                    contatoPorNome.add(c);
                }
            }
            return contatoPorNome;
        } else {
            throw new RuntimeException();
        }
    }

    public void atualizarNumeroContato(int numero, int novoNumero) {
        if(!contatos.isEmpty()) {
            for(Contato c : contatos) {
                if(c.getNumeroTelefone() == numero) {
                    c.setNumeroTelefone(novoNumero);
                    System.out.println("Numero atualizado com sucesso");
                }
            }
        } else {
            System.out.println("Lista de contatos vazia");
        }
    }

    public static void main(String[] args) {
        AgendaContatos agendaContatos = new AgendaContatos();

        agendaContatos.adicionarContato("Joao Paulo", 999999911);
        agendaContatos.adicionarContato("Joao pedro", 999999912);
        agendaContatos.adicionarContato("Carlos", 999999912);
        agendaContatos.adicionarContato("Renan", 999999913);
        agendaContatos.adicionarContato("Joao", 999999914);

        agendaContatos.exibirContatos();

        try {
            System.out.println(agendaContatos.pesquisarPorNome("Joao"));
        } catch (RuntimeException e) {
            System.out.println("Lista de contatos vazia");
        }

        agendaContatos.atualizarNumeroContato(999999911, 999999915);
        agendaContatos.exibirContatos();
    }
}
