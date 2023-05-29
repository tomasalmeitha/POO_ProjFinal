package Entidades;


/**
 * A classe 'NPC' representa o adversário do herói no jogo.
 * Advém da super classe 'Entidade'
 * */
public class NPC extends Entidade {

    /**
     * Construtor 'NPC' que constrói um objecto com os seguintes atributos:
     *
     * @param nome - nome do NPC
     * @param HP - pontos de vida do NPC
     * @param forca - pontos de força do NPC
     * */

    public NPC(String nome, int HP, int forca) {
        super(nome, HP, forca);
    }

    /**
     * Apresenta os detalhes do NPC. Sobreescreve o método 'mostrarDetalhes' que advém de 'Entidade', que inclui, nome, HP, e pontos de força do NPC.
     * */

    @Override
    public void mostrarDetalhes() {
        System.out.println("Nome do NPC: " +getNome());
        System.out.println("Vida: " +getHP());
        System.out.println("Força: " +getForca());
    }


}
