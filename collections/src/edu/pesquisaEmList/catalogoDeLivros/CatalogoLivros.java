package edu.pesquisaEmList.catalogoDeLivros;

import java.util.ArrayList;
import java.util.List;

public class CatalogoLivros {
    private List<Livro> catalogoLivros;

    public CatalogoLivros() {
        this.catalogoLivros = new ArrayList<>();
    }

    public void adicionarLivro(String titulo, String autor, int anoPublicacao) {
        catalogoLivros.add(new Livro(titulo, autor, anoPublicacao));
    }

    public List<Livro> pesquisarPorAutor(String autor) {
        List<Livro> livroPorAutor = new ArrayList<>();
        if(!catalogoLivros.isEmpty()) {
            for (Livro livro : catalogoLivros) {
                if (livro.getAutor().equalsIgnoreCase(autor)) {
                    livroPorAutor.add(livro);
                }
            }
        }
        return livroPorAutor;
    }

    public  List<Livro> pesquisarPorIntervaloAnos(int anoInicial, int anoFinal) {
        List<Livro> livroPorIntervaloAnos = new ArrayList<>();
        if(!catalogoLivros.isEmpty()) {
            for (Livro livro : catalogoLivros) {
                if (livro.getAnoPublicacao() >= anoInicial && livro.getAnoPublicacao() <= anoFinal) {
                    livroPorIntervaloAnos.add(livro);
                }
            }
        }
        return livroPorIntervaloAnos;
    }

   public Livro pesquisarPorTitulo(String titulo){
        Livro livroPorTitulo = null;
        if(!catalogoLivros.isEmpty()) {
            for (Livro livro : catalogoLivros) {
                if (livro.getTitulo().equalsIgnoreCase(titulo)) {
                    livroPorTitulo = livro;
                    break;
                }
            }
        }
       return livroPorTitulo;
   }

    public static void main(String[] args) {
        CatalogoLivros catalogoLivros = new CatalogoLivros();

        catalogoLivros.adicionarLivro("The hunger games", "Suzane Collins", 2013);
        catalogoLivros.adicionarLivro("A map of days", "Rason Riggs", 2014);
        catalogoLivros.adicionarLivro("harry potter", "JK Rolling", 2001);
        catalogoLivros.adicionarLivro("harry potter", "JK Rolling", 2002);
        catalogoLivros.adicionarLivro("Catching fire", "Suzane Collins", 2016);

        System.out.println(catalogoLivros.pesquisarPorTitulo("harry potter"));
    }
}
