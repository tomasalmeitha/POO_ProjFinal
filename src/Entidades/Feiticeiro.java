package Entidades;

import Itens.Arma;
import Itens.PocaoHP;

import java.util.ArrayList;

public class Feiticeiro extends Heroi {

    public Feiticeiro(String nome, int HP, int forca, int nivel, int ouro, Arma arma, ArrayList<PocaoHP> pocoes) {
        super(nome, HP, forca, nivel, ouro, arma, pocoes);
    }

    public Feiticeiro() {
    }

    @Override
    public void atacar(NPC npc) {
        super.atacar(npc);

        int danoHeroi = getForca() + getArma().getAtaque();
        int danoNPC = npc.getForca();

        //Herói ataca primeiro
        npc.setHP(npc.getHP() - danoHeroi);

        if(npc.getHP() <= 0) {
            System.out.println("Feiticeiro derrotou o inimigo " +npc.getNome());
        }

        //NPC ataca de seguida
        this.setHP(this.getHP() - danoNPC);

        if(this.getHP() <= 0){
            System.out.println("Feiticeiro foi derrotado pelo inimigo " +npc.getNome());
        }
    }

    @Override
    public void mostrarDetalhes() {
        System.out.println("Detalhes do Feiticeiro:");
        System.out.println("Nome: " + getNome());
        System.out.println("HP: " + getHP());
        System.out.println("Força: " + getForca());
        System.out.println("Nível: " + getNivel());
        System.out.println("Ouro: " + getOuro());
        System.out.println("Arma: " + getArma().getNome());
        System.out.println("Poções: " + getPocoes().size());
    }
}
