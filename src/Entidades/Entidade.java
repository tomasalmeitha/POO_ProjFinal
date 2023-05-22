package Entidades;

public abstract class Entidade {

    private String nome;
    private int HP, forca;

    public Entidade(String nome, int HP, int forca) {
        this.nome = nome;
        this.HP = HP;
        this.forca = forca;
    }

    public abstract void mostrarDetalhes();
}
