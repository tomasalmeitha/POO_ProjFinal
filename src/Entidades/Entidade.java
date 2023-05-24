package Entidades;

public abstract class Entidade {

    private String nome;
    private int HP, forca;

    public Entidade(String nome, int HP, int forca) {
        this.nome = nome;
        this.HP = HP;
        this.forca = forca;
    }

    public Entidade() {

    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getHP() {
        return HP;
    }

    public void setHP(int HP) {
        this.HP = HP;
    }

    public int getForca() {
        return forca;
    }

    public void setForca(int forca) {
        this.forca = forca;
    }

    public void mostrarDetalhes(){

    }

}
