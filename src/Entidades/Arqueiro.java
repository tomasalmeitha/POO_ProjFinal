package Entidades;

import Itens.Arma;
import Itens.PocaoHP;

import java.util.ArrayList;

public class Arqueiro extends Heroi {

    public Arqueiro(String nome, int HP, int forca, int nivel, int ouro, Arma arma, ArrayList<PocaoHP> pocoes) {
        super(nome, HP, forca, nivel, ouro, arma, pocoes);
    }

    public Arqueiro() {

    }

    @Override
    public void atacar(NPC npc) {
        super.atacar(npc);

        int danoHeroi =  getForca() + getArma().getAtaque();
        int danoNPC = npc.getForca();

        //Heroi ataca primeiro
        npc.setHP(npc.getHP() - danoHeroi);

        //NPC morreu?...
        if(npc.getHP() <= 0){
            System.out.println("Arqueiro derrotou o inimigo " + npc.getNome());
        }

        //NPC ataca em segundo e inflige mais 10% de dano ao Heroi
        int danoSeguinteNPC = (int) (danoNPC*1.1);
        this.setHP(this.getHP() - danoSeguinteNPC);

        //NPC morreu?...
        if(this.getHP() <= 0){
            System.out.println("Arqueiro foi derrotado pelo inimigo " + npc.getNome());

        }

    }

    @Override
    public void mostrarDetalhes() {
        System.out.println("Detalhes do Arqueiro:");
        System.out.println("Nome: " + getNome());
        System.out.println("HP: " + getHP());
        System.out.println("Força: " + getForca());
        System.out.println("Nível: " + getNivel());
        System.out.println("Ouro: " + getOuro());
        System.out.println("Arma: " + getArma().getNome());
        System.out.println("Poções: " + getPocoes().size());
    }
}
