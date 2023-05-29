package Entidades;

public abstract class Entidade {

    /**
     * A classe 'Entidade' representa a entidade no jogo. É uma classe abstracta que providencia atributos comuns e métodos para as suas subclasses
     * */
    private String nome;
    private int HP, forca;

    /**
     * Construtor 'Entidade' que constrói um objecto com os seguintes atributos:
     *
     * @param nome - o nome da entidade
     * @param HP - pontos de vida da entidade
     * @param forca - pontos de força da entidade
     *
     * */

    public Entidade(String nome, int HP, int forca) {
        this.nome = nome;
        this.HP = HP;
        this.forca = forca;
    }

    /**
     * Constrói um objecto a partir de 'Entidade' predefinido.
     * */
    public Entidade() {

    }

    /**
     * Devolve o nome da entidade.
     *
     * @return o nome da entidade.
     * */

    public String getNome() {
        return nome;
    }

    /**
     * Actualiza o nome da entidade.
     *
     * @param nome - o nome da entidade
     * */

    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Devolve os pontos de vida(HP) da entidade.
     *
     * @return os pontos de vida da entidade.
     * */

    public int getHP() {
        return HP;
    }

    /**
     * Actualiza os pontos de vida da entidade.
     *
     * @param HP - pontos de vida da entidade
     * */

    public void setHP(int HP) {
        this.HP = HP;
    }

    /**
     * Devolve os pontos de força da entidade.
     *
     * @return os pontos de força da entidade
     * */

    public int getForca() {
        return forca;
    }

    /**
     * Actualiza os pontos de força da entidade.
     *
     * @param forca - pontos de força da entidade
     * */

    public void setForca(int forca) {
        this.forca = forca;
    }

    /**
     * Apresenta os detalhes da entidade. É um método que é sobreescrito pelas suas subclasses com os detalhes pretendidos.
     * */

    public void mostrarDetalhes(){

    }

}
