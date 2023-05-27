package Entidades;

import Itens.PocaoHP;

import java.util.ArrayList;

public class Cavaleiro extends Heroi {

    public Cavaleiro(String nome, int HP, int forca, int ouro , ArrayList<PocaoHP> pocoes) {
        super(nome, HP, forca, ouro);
    }

    public Cavaleiro() {
    }

    @Override
    public boolean atacar(NPC npc) {

        int danoHeroi = getForca();
        int danoNPC = (int) (npc.getForca()*0.8);


        while (npc.getHP() > 0 && this.getHP() > 0) {

            //NPC ataca primeiro
            this.setHP(this.getHP() - danoNPC);

            if (this.getHP() <= 0) {
                System.out.println();
                System.out.println("Cavaleiro foi derrotado pelo inimigo " + npc.getNome());
                return false;
            }

            //Cavaleiro ataca de seguida
            npc.setHP(npc.getHP() - danoHeroi);

            if (npc.getHP() <= 0) {
                System.out.println();
                System.out.println("Cavaleiro derrotou o inimigo " + npc.getNome());
                return true;
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
