package Itens;

import Entidades.Heroi;

import java.util.ArrayList;

public abstract class ItemHeroi {
    private String nome;
    private int preco;
    private ArrayList<String> tipoHeroi;

    public ItemHeroi(String nome, int preco, ArrayList<String> tipoHeroi) {
        this.nome = nome;
        this.preco = preco;
        this.tipoHeroi = tipoHeroi;
    }

    public String getNome() {
        return nome;
    }

    public int getPreco() {
        return preco;
    }

    public ArrayList<String> getTipoHeroi() {
        return tipoHeroi;
    }

    public void mostrarDetalhes() {
        System.out.println("Nome: " +getNome());
        System.out.println("Preço: " +getPreco());
        System.out.println("Herói apto a usar: " +getTipoHeroi());
    }
}