package Entidades;

import Itens.Arma;
import Itens.ItemHeroi;
import Itens.PocaoHP;

import java.util.ArrayList;

public class Vendedor {
    private ArrayList<ItemHeroi> itens;

    public Vendedor(ArrayList<ItemHeroi> itens) {
        this.itens = new ArrayList<>();
    }

    public void imprimirInventario() {
        for (ItemHeroi item : itens) {
            item.mostrarDetalhes();
        }
    }

    public void vender(Heroi heroi, ItemHeroi item){

        if(heroi.getOuro() >= item.getPreco()){

            heroi.setOuro(heroi.getOuro() - item.getPreco());

            if(item instanceof Arma){
                heroi.setArma((Arma) item);
                System.out.println("Item comprado: " +item.getNome()+ " Arma");
            }
            if (item instanceof PocaoHP){
                heroi.adicionarPocaoHP((PocaoHP) item);
                System.out.println("Poção comprada: " +item.getNome()+ " Poção de HP");
            }
            else {
                System.out.println("A compra não pode ser efectuada!");
            }
        }
    }

}
