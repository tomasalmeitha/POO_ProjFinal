package Itens;

import Entidades.Heroi;

import java.util.ArrayList;

/**
 * 'ItemHeroi' representa uma classe abstracta dos itens que são possíveis usar pelos heróis no jogo.
 * Providencia atributos e métodos que são comuns a todos os itens.
 * */
public abstract class ItemHeroi {
    private String nome;
    private int preco;
    private ArrayList<String> tipoHeroi;

    /**
     * Constrói um objecto 'ItemHeroi' com os seguintes atributos:
     *
     * @param nome - o nome do item
     * @param preco - preço do item
     * @param tipoHeroi - lista de tipos de herói que podem usar o item
     * */

    public ItemHeroi(String nome, int preco, ArrayList<String> tipoHeroi) {
        this.nome = nome;
        this.preco = preco;
        this.tipoHeroi = tipoHeroi;
    }

    /**
     * Devolve o nome do item.
     *
     * @return o nome do item
     * */

    public String getNome() {
        return nome;
    }

    /**
     * Devolve o preço do item.
     *
     * @return o preço do item
     * */

    public int getPreco() {
        return preco;
    }

    /**
     * Devolve a lista dos tipos de herói que podem usar o item.
     * */

    public ArrayList<String> getTipoHeroi() {
        return tipoHeroi;
    }

    /**
     * Apresenta os detalhes do item.
     * Este método tem como propósito ser sobreescrito pelas subclasses 'Arma' e 'PocaoHP'
     * */

    public void mostrarDetalhes() {
//        System.out.println("Nome: " +getNome());
//        System.out.println("Preço: " +getPreco());
//        System.out.println("Herói apto a usar: " +getTipoHeroi());
    }
}