package Entidades;

public class NPC extends Entidade {

    private String nome;
    private int vida, forca;

    public NPC(String nome, int HP, int forca) {
        super(nome, HP, forca);
    }

    @Override
    public void mostrarDetalhes() {
        System.out.println("Nome do NPC: " +this.nome);
        System.out.println("Vida: " +this.vida);
        System.out.println("Força: " +this.forca);
    }


}
