package Entidades;

import Itens.Arma;
import Itens.PocaoHP;

import java.util.ArrayList;

public class Cavaleiro extends Heroi {

    public Cavaleiro(String nome, int HP, int forca, int nivel, int ouro, Arma arma, ArrayList<PocaoHP> pocoes) {
        super(nome, HP, forca, nivel, ouro, arma);
    }

    public Cavaleiro() {
    }

    @Override
    public void atacar(NPC npc) {
        super.atacar(npc);


        int danoHeroi = getForca() + getArma().getAtaque();
        int danoNPC = npc.getForca();


        while (npc.getHP() > 0 && this.getHP() > 0) {

            //NPC ataca primeiro
            this.setHP(this.getHP() - danoNPC);

            if (this.getHP() <= 0) {
                System.out.println("Cavaleiro foi derrotado pelo inimigo " + npc.getNome());
            }

            //Cavaleiro ataca de seguida
            npc.setHP(npc.getHP() - danoHeroi);

            if (npc.getHP() <= 0) {
                System.out.println("Cavaleiro derrotou o inimigo " + npc.getNome());

            }
        }
    }

    @Override
    public void mostrarDetalhes() {
        System.out.println("Detalhes do Cavaleiro:");
        System.out.println("Nome: " + getNome());
        System.out.println("HP: " + getHP());
        System.out.println("Força: " + getForca());
        System.out.println("Nível: " + getNivel());
        System.out.println("Ouro: " + getOuro());
        System.out.println("Arma: " + getArma().getNome());
        System.out.println("Poções: " + getPocoes().size());
    }
}
