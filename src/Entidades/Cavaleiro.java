package Entidades;

import Itens.PocaoHP;

import java.util.ArrayList;

/**
 * A classe 'Cavaleiro' representa um tipo de herói de nome 'Cavaleiro'.
 * Advém da super classe 'Heroi' e implementa os métodos 'atacar' e 'mostrarDetalhes'
 *
 * */
public class Cavaleiro extends Heroi {

    /**
     * Construtor 'Cavaleiro' que constrói um objecto 'Cavaleiro' com os seguintes atributos
     *
     * @param nome - nome do Cavaleiro
     * @param HP - pontos de vida do Cavaleiro
     * @param forca - pontos de força do Cavaleiro
     * @param ouro - moedas de ouro do Cavaleiro
     * @param pocoes - pocoes na posso do Cavaleiro
     *
     *
     * */
    public Cavaleiro(String nome, int HP, int forca, int ouro , ArrayList<PocaoHP> pocoes) {
        super(nome, HP, forca, ouro);
    }

/**
 * Constrói um objecto da classe 'Cavaleiro' predefinido
 * */
    public Cavaleiro() {
    }

    /**
     *
     *Sobreescreve o método 'atacar' que advém da classe 'Herói'
     * e implementa a lógica especifica para o Cavaleiro.
     *
     * @param npc representa o adversário do Cavaleiro
     * @return true se o Cavaleiro derrotar o NPC e torna false caso contrário
     * */
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

    /**
     * Sobreescreve o método 'mostrarDetalhes' vindo da classe Herói.
     * Apresenta os detalhes do Cavaleiro
     * */
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
