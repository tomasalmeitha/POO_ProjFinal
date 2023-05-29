package Itens;

import Entidades.Heroi;

import java.util.ArrayList;

/**
 * A classe 'Arma' representa é um item do tipo arma podendo ser usada pelos heróis do jogo.
 * Advém da classe abstracta 'ItemHeroi' com atributos adicionais e métodos especificos de arma.
 * */
public class Arma extends ItemHeroi {

    private int ataque;

    /**
     * Construtor 'Arma' que constrói um objecto com os seguintes atributos:
     *
     * @param nome - nome da arma
     * @param preco - preço da arma
     * @param tipoHeroi - lista de heróis que podem usar uma dada arma
     * @param ataque - o poder de ataque da arma
     * */

    public Arma(String nome, int preco, ArrayList<String> tipoHeroi, int ataque) {
        super(nome, preco, tipoHeroi);
        this.ataque = ataque;
    }

    /**
     * Devolve o poder de ataque da arma
     *
     * @return poder de ataque
     * */

    public int getAtaque() {
        return ataque;
    }

    /**
     * Apresenta os detalhes da arma, nome, preço, tipos de herói que podem usar e poder de ataque
     * */
    @Override
    public void mostrarDetalhes() {
        super.mostrarDetalhes();

        System.out.println("Nome arma: " +getNome());
        System.out.println("Preço da arma: " +getPreco());
        System.out.println("Tipos de herói que podem usar: " +getTipoHeroi());
        System.out.println("Poder do ataque: " +getAtaque());
    }
}
