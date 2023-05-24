package Itens;

import Entidades.Heroi;

import java.util.ArrayList;

public class PocaoHP extends ItemHeroi {

    private int cura;

    public PocaoHP(String nome, int preco, ArrayList<String> tipoHeroi, int cura) {
        super(nome, preco, tipoHeroi);
        this.cura = cura;
    }

    public int getCura() {
        return cura;
    }

    public void setCura(int cura) {
        this.cura = cura;
    }

    @Override
    public void mostrarDetalhes() {
        super.mostrarDetalhes();

        System.out.println("Nome da poção: " +getNome());
        System.out.println("Preço da poção: " +getPreco());
        System.out.println("Poder de cura: " +getCura());
    }
}
