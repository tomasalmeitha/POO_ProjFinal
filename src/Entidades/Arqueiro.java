package Entidades;

import Itens.PocaoHP;

import java.util.ArrayList;

/**
 * A classe 'Arqueiro' representa um tipo de herói de nome 'Arqueiro'.
 * Advém da super classe 'Heroi' e implementa os métodos 'atacar' e 'mostrarDetalhes'
 *
 * */

public class Arqueiro extends Heroi {

    /**
     * Construtor 'Arqueiro' que constrói um objecto com os seguintes atributos
     *
     * @param nome - nome do Arqueiro
     * @param HP - pontos de vida do Arqueiro
     * @param forca - pontos de força do Arqueiro
     * @param ouro - moedas de ouro do Arqueiro
     * @param pocoes - pocoes na posso do Arqueiro
     *
     *
     * */

    public Arqueiro(String nome, int HP, int forca, int ouro, ArrayList<PocaoHP> pocoes) {
        super(nome, HP, forca, ouro);
    }

    /**
     * Constrói um objecto da classe 'Arqueiro' predefinido
     * */
    public Arqueiro() {

    }

    /**
     *
     *Sobreescreve o método 'atacar' que advém da classe 'Herói'
     * e implementa a lógica especifica para o Arqueiro.
     *
     * @param npc representa o adversário do Arqueiro
     * @return true se o Arqueiro derrotar o NPC e torna false caso contrário
     * */
    @Override
    public boolean atacar(NPC npc) {

        int danoHeroi = getForca();
        int danoNPC = npc.getForca();


        while (npc.getHP() > 0 && this.getHP() > 0) {

            //Heroi ataca primeiro
            npc.setHP(npc.getHP() - danoHeroi);

            //NPC morreu?...
            if (npc.getHP() <= 0) {
                System.out.println();
                System.out.println("Arqueiro derrotou o inimigo " + npc.getNome());
                return true;
            }

            //NPC ataca em segundo e inflige mais 10% de dano ao Heroi
            int danoSeguinteNPC = (int) (danoNPC * 1.1);
            this.setHP(this.getHP() - danoSeguinteNPC);

            //NPC morreu?...
            if (this.getHP() <= 0) {
                System.out.println();
                System.out.println("Arqueiro foi derrotado pelo inimigo " + npc.getNome());
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
     * Apresenta os detalhes do Arqueiro
     * */

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
