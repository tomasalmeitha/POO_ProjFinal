package Entidades;

public class NPC extends Entidade {


    public NPC(String nome, int HP, int forca) {
        super(nome, HP, forca);
    }


    @Override
    public void mostrarDetalhes() {
        System.out.println("Nome do NPC: " +getNome());
        System.out.println("Vida: " +getHP());
        System.out.println("Força: " +getForca());
    }


}
