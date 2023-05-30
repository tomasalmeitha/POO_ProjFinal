package Entidades;

import Itens.PocaoHP;

import java.util.ArrayList;

/**
 * A classe 'Feiticeiro' representa um tipo de herói de nome 'Feiticeiro' no jogo.
 * Advém da classe 'Herói' e implementa os métodos 'atacar' e 'mostrarDetalhes' respectivos
 * */

public class Feiticeiro extends Heroi {

    /**
     * Construtor 'Feiticeiro' que constrói um objecto com os seguintes atributos:
     *
     * @param nome - o nome do Feiticeiro
     * @param HP - pontos de vida do Feiticeiro
     * @param forca - pontos de forca do Feiticeiro
     * @param ouro - moedas de ouro do Feiticeiro
     * @param pocoes - lista de poções na posse do Feiticeiro
     * */
    public Feiticeiro(String nome, int HP, int forca, int ouro, ArrayList<PocaoHP> pocoes) {
        super(nome, HP, forca, ouro);
    }

    /**
     * Constrói um objecto da classe 'Feiticeiro' predefinido
     * */
    public Feiticeiro() {
    }

    /**
     *
     *Sobreescreve o método 'atacar' que advém da classe 'Herói'
     * e implementa a lógica especifica para a o Feiticeiro.
     *
     * @param npc representa o adversário do Feiticeiro
     * @return true se o Feiticeiro derrotar o NPC e torna false caso contrário
     * */
    @Override
    public boolean atacar(NPC npc) {

        int danoHeroi = getForca();
        int danoNPC = npc.getForca();

        while (npc.getHP() > 0 && this.getHP() > 0) {

            //Herói ataca primeiro
            npc.setHP(npc.getHP() - danoHeroi);
            //No caso do Feiticeiro vencer a batalha, sobe um nível, recebe 10 pontos de vida, 1 de força e 10 moedas de ouro
            if (npc.getHP() <= 0) {
                System.out.println();
                System.out.println("Feiticeiro derrotou o inimigo " + npc.getNome());
                this.setNivel(this.getNivel()+1);
                this.setHP(this.getHP()+10);
                this.setForca(this.getForca()+1);
                this.setOuro(this.getOuro()+10);
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

    /**
     * Sobreescreve o método 'mostrarDetalhes' vindo da classe Herói.
     * Apresenta os detalhes do Feiticeiro
     * */

    @Override
    public void mostrarDetalhes() {
        System.out.println();
        System.out.println("Detalhes do Feiticeiro:");
        System.out.println("Nome: " + getNome());
        System.out.println("HP: " + getHP());
        System.out.println("Força: " + getForca());
        System.out.println("Nível: " + getNivel());
        System.out.println("Ouro: " + getOuro());
//        System.out.println("Arma: " + getArma().getNome());
//        System.out.println("Poções: " + getPocoes().size());
    }
}
