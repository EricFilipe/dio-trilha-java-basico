package edu.ordenacao.map.livrariaOnline;

import java.util.*;

public class LivrariaOnline {
    private Map<String, Livro> livraria;

    public LivrariaOnline() {
        this.livraria = new HashMap<>();
    }

    public void adicionarLivro(String link, String titulo, String autor, double preco) {
        livraria.put(link, new Livro(titulo, autor, preco));
    }

    public void removerLivro(String titulo) {
        if(!livraria.isEmpty()) {
            List<String> cahvesParaRemover = new ArrayList<>();
            for(Map.Entry<String, Livro> entry : livraria.entrySet()) {
                if(entry.getValue().getTitulo().equalsIgnoreCase(titulo)) {
                    cahvesParaRemover.add(entry.getKey());
                }
            }
            for(String chave : cahvesParaRemover) {
                livraria.remove(chave);
            }
        } else {
            System.out.println("Nenhum livro na livraria");
        }
    }

    public void exibirLivrosOrdenadosPorPreco() {
        if(!livraria.isEmpty()) {
            List<Map.Entry<String, Livro>> livrosParaOrdenarPorPreco = new ArrayList<>(livraria.entrySet());
            livrosParaOrdenarPorPreco.sort(new OrdenarPorPreco());
            System.out.println(livrosParaOrdenarPorPreco);
        } else {
            System.out.println("Nenhum livro na livraria");
        }
    }

    public Map<String, Livro> pesquisarLivrosPorAutor(String autor) {
        if(!livraria.isEmpty()) {
            Map<String, Livro> livrosPorAutor = new LinkedHashMap<>();
            for(Map.Entry<String, Livro> entry : livraria.entrySet()) {
                if(entry.getValue().getAutor().equalsIgnoreCase(autor)) {
                    livrosPorAutor.put(entry.getKey(), entry.getValue());
                }
            }

            if(livrosPorAutor.isEmpty()) {
                System.out.println("Autor nao encontrado");
            }
            return livrosPorAutor;
        } else {
            throw new RuntimeException();
        }
    }

    public Livro obterLivroMaisCaro() {
        if(!livraria.isEmpty()) {
            Livro livroMaisCaro = null;
            double valorMaisAlto = 0;
            for(Livro l : livraria.values()) {
                if(l.getPreco() > valorMaisAlto) {
                    valorMaisAlto = l.getPreco();
                    livroMaisCaro = l;
                }
            }
            return livroMaisCaro;
        } else {
            throw new RuntimeException();
        }
    }

    public Livro exibirLivroMaisBarato() {
        if(!livraria.isEmpty()) {
            Livro livroMaisBarato = null;
            double valorMaisBaixo = Double.MAX_VALUE;
            for(Livro l : livraria.values()) {
                if(l.getPreco() < valorMaisBaixo) {
                    valorMaisBaixo = l.getPreco();
                    livroMaisBarato = l;
                }
            }
            return livroMaisBarato;
        } else {
            throw new RuntimeException();
        }
    }

    public static void main(String[] args) {
        LivrariaOnline livrariaOnline = new LivrariaOnline();

        livrariaOnline.adicionarLivro("978-8532517458", "Harry Potter", "JK Rolling", 49.9);
        livrariaOnline.adicionarLivro("978‑8579800245", "Jogos vorazes", "Suzanne Collins", 59.9);
        livrariaOnline.adicionarLivro("978‑8533613409", "O senhor dos aneis", "J.R.R Tolkien", 70.0);
        livrariaOnline.adicionarLivro("978‑8532529961", "Harry Potter", "JK Rolling", 29.9);

        System.out.println(livrariaOnline.livraria);

        System.out.println(livrariaOnline.pesquisarLivrosPorAutor("J.R.R Tolkien"));

        System.out.println("Livro mais caro: " + livrariaOnline.obterLivroMaisCaro());

        System.out.println("Livro mais barato: " + livrariaOnline.exibirLivroMaisBarato());

        livrariaOnline.exibirLivrosOrdenadosPorPreco();

        livrariaOnline.removerLivro("Harry potter");
        System.out.println(livrariaOnline.livraria);
    }
}
