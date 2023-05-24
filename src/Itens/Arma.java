package Itens;

import Entidades.Heroi;

import java.util.ArrayList;

public class Arma extends ItemHeroi {

    private int ataque;

    public Arma(String nome, int preco, ArrayList<String> tipoHeroi, int ataque) {
        super(nome, preco, tipoHeroi);
        this.ataque = ataque;
    }

    public int getAtaque() {
        return ataque;
    }

    @Override
    public void mostrarDetalhes() {
        super.mostrarDetalhes();

        System.out.println("Nome arma: " +getNome());
        System.out.println("Preço da arma: " +getPreco());
        System.out.println("Tipos de herói que podem usar: " +getTipoHeroi());
        System.out.println("Poder do ataque: " +getAtaque());
    }
}
