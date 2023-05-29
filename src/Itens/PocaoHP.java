package Itens;

import Entidades.Heroi;

import java.util.ArrayList;

public class PocaoHP extends ItemHeroi {

    private int cura;

    /**
     * A classe 'PocaoHP' representa o item poção de cura que é possível ser usado pelo herói. Advém da classe 'ItemHeroi'
     *
     * */

    /**
     * Construtor 'PocaoHP' que constrói um objecto com os seguintes atributos:
     *
     * @param nome - o nome da poção
     * @param preco - o preço da poção
     * @param tipoHeroi - a lista de heróis que podem usar a poção
     * @param cura - o poder de cura da poção
     *
     * */
    public PocaoHP(String nome, int preco, ArrayList<String> tipoHeroi, int cura) {
        super(nome, preco, tipoHeroi);
        this.cura = cura;
    }

    /**
     * Devolve o poder de cura da poção.
     *
     * @return o poder de cura da poção
     *
     * */

    public int getCura() {
        return cura;
    }

    /**
     * Actualiza o poder de cura da poção.
     *
     * @param cura - poder de cura da poção
     *
     * */

    public void setCura(int cura) {
        this.cura = cura;
    }

    /**
     * Apresenta os detalhes da poção de cura. Sobreescreve o método 'mostrarDetalhes' em 'ItemHeroi'.
     * Inclui o nome, preço e poder de cura.
     *
     * */

    @Override
    public void mostrarDetalhes() {
        super.mostrarDetalhes();

        System.out.println("Nome da poção: " +getNome());
        System.out.println("Preço da poção: " +getPreco());
        System.out.println("Poder de cura: " +getCura());
    }
}
