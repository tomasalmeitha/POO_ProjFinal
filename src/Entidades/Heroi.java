package Entidades;

import Itens.Arma;
import Itens.PocaoHP;

import java.util.ArrayList;

public abstract class Heroi extends Entidade {

    private int nivel, ouro;
    private Arma arma;
    private ArrayList<PocaoHP> pocoes;

    public Heroi(String nome, int HP, int forca, int nivel, int ouro, Arma arma) {
        super(nome, HP, forca);
        this.nivel = nivel;
        this.ouro = ouro;
        this.arma = arma;
        this.pocoes = new ArrayList<PocaoHP>();
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public int getOuro() {
        return ouro;
    }

    public void setOuro(int ouro) {
        this.ouro = ouro;
    }

    public Arma getArma() {
        return arma;
    }

    public void setArma(Arma arma) {
        this.arma = arma;
    }

    public ArrayList<PocaoHP> getPocoes() {
        return pocoes;
    }

    public void setPocoes(ArrayList<PocaoHP> pocoes) {
        this.pocoes = pocoes;
    }

    public void atacar(NPC npc){

    }
}
