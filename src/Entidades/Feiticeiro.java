package Entidades;

import Itens.PocaoHP;

import java.util.ArrayList;

public class Feiticeiro extends Heroi {

    public Feiticeiro(String nome, int HP, int forca, int ouro, ArrayList<PocaoHP> pocoes) {
        super(nome, HP, forca, ouro);
    }

    public Feiticeiro() {
    }

    @Override
    public boolean atacar(NPC npc) {

        int danoHeroi = getForca();
        int danoNPC = npc.getForca();

        while (npc.getHP() > 0 && this.getHP() > 0) {

            //Herói ataca primeiro
            npc.setHP(npc.getHP() - danoHeroi);

            if (npc.getHP() <= 0) {
                System.out.println();
                System.out.println("Feiticeiro derrotou o inimigo " + npc.getNome());
                return true;
            }

            //NPC ataca de seguida
            this.setHP(this.getHP() - danoNPC);

            if (this.getHP() <= 0) {
                System.out.println();
                System.out.println("Feiticeiro foi derrotado pelo inimigo " + npc.getNome());
                return false;
            }

            //Empate conta como vitória do herói
            if (this.getHP() <= 0 && npc.getHP() <= 0) {
                System.out.println("O combate terminou em empate!");
                return true;
            }
        }
        return false;
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
