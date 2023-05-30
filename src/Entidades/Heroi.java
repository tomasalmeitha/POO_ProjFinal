package Entidades;

import Itens.Arma;
import Itens.PocaoHP;

import java.util.ArrayList;


/**
 * A classe 'Herói' representa a entidade herói do jogo. É também uma classe abstracta com atributos e métodos comuns às suas subclasses.
 * */
public abstract class Heroi extends Entidade {

    private int nivel, ouro;
    private Arma arma;
    private ArrayList<PocaoHP> pocoes = new ArrayList<>();

    /**
     * Construtor 'Heroi' que constrói um objecto com os seguintes atributos:
     *
     * @param nome - nome do herói
     * @param HP - pontos de vida do herói
     * @param forca - pontos de força do herói
     * @param ouro - moedas de ouro que o herói possui
     * */
    public Heroi(String nome, int HP, int forca, int ouro) {
        super(nome, HP, forca);
        this.ouro = ouro;

    }

    /**
     * Constrói um objecto predefinido da classe 'Herói'
     * */
    public Heroi() {
        super();
    }

    /**
     * Apresenta os detalhes do herói, como o nome, nivel, pontos de vida, pontos de força, ouro e o nome da arma que possui.
     *
     * */

    public void mostrarDetalhes() {
        System.out.println("Nome: " +getNome());
        System.out.println("Nível: " +this.nivel);
        System.out.println("Vida: " +getHP());
        System.out.println("Força: " +getForca());
        System.out.println("Ouro: " +this.ouro);
        System.out.println("Arma: " +arma.getNome());
    }

    /**
     * Adiciona uma poção de vida(HP) ao inventário do herói.
     *
     * @param pocaoHP - representa o item pocaoHP a adicionar
     * */

    public void adicionarPocaoHP(PocaoHP pocaoHP){
        this.pocoes.add(pocaoHP);
//        System.out.println("Item adicionado ao inventário: " +pocaoHP.getNome());
    }

    /**
     * Remove uma poção de vida(HP) ao inventário do herói.
     *
     * @param pocaoHP pocaoHP a ser removida.
     * */

    public void removePocaoHP(PocaoHP pocaoHP){
        this.pocoes.remove(pocaoHP);
//        System.out.println("Item retirado ao inventário: " +pocaoHP.getNome());
    }

    /**
     * Devolve o nível do herói.
     *
     * @return o nível do herói.
     *
     * */

    public int getNivel() {
        return nivel;
    }

    /**
     * Actualiza o nível do herói.
     *
     * @param nivel representa o nível do herói
     *
     * */
    public void setNivel(int nivel) {
        this.nivel = nivel;
    }


    /**
     * Devolve a quantidade de ouro que o herói possui.
     *
     * @return a quantidade de ouro
     * */

    public int getOuro() {
        return ouro;
    }

    /**
     * Actualiza a quantidade de ouro que o herói possui.
     *
     * @return a quantidade de ouro
     *
     * */

    public void setOuro(int ouro) {
        this.ouro = ouro;
    }

    /**
     * Devolve a arma que o herói tem equipada.
     *
     * @return a arma equipada
     *
     * */
    public Arma getArma() {
        return arma;
    }

    /**
     * Actualiza a arma que o herói vai utilizar.
     *
     * @param arma a arma a ser equipada
     * */

    public void setArma(Arma arma) {
        this.arma = arma;

    }

    /**
     * Devolve a lista de poções de vida(HP) no inventário do herói.
     *
     * @return a lista de poções de vida
     * */

    public ArrayList<PocaoHP> getPocoes() {
        return pocoes;
    }

    /**
     * Actualiza a lista de poções no inventário do herói.
     *
     * @param pocoes a lista de poções de vida
     * */

    public void setPocoes(ArrayList<PocaoHP> pocoes) {
        this.pocoes = pocoes;
    }

    /**
     * Método que implementa um ataque contra um NPC e retorna o resultado do ataque.
     *
     * @param npc o NPC a ser atacado.
     * @return 'true' se o herói vencer, 'falso' caso contrário.
     *
     * */

    public boolean atacar(NPC npc){

        return false;
    }
}
