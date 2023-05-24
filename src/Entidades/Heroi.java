package Entidades;

import Itens.Arma;
import Itens.PocaoHP;

import java.util.ArrayList;

public abstract class Heroi extends Entidade {

    private int nivel, ouro;
    private Arma arma;
    private ArrayList<PocaoHP> pocoes;

    public Heroi(String nome, int HP, int forca, int nivel, int ouro, Arma arma, ArrayList<PocaoHP> pocoes) {
        super(nome, HP, forca);
        this.nivel = nivel;
        this.ouro = ouro;
        this.arma = arma;
        this.pocoes = pocoes;
    }

    public Heroi() {
        super();
    }


    public void mostrarDetalhes() {
        System.out.println("Nome: " +getNome());
        System.out.println("Nível: " +this.nivel);
        System.out.println("Vida: " +getHP());
        System.out.println("Força: " +getForca());
        System.out.println("Ouro: " +this.ouro);
        System.out.println("Arma: " +arma.getNome());
    }

    public void adicionarPocaoHP(PocaoHP pocaoHP){
        this.pocoes.add(pocaoHP);
        System.out.println("Poção adicionada ao inventário: " +pocaoHP.getNome());
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
