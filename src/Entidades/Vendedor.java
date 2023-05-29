package Entidades;

import Itens.Arma;
import Itens.ItemHeroi;
import Itens.PocaoHP;

import java.util.ArrayList;
import java.util.Scanner;


/**
 * A classe 'Vendedor' representa um vendedor que vende itens a heróis
 * */

public class Vendedor {

    private ArrayList<ItemHeroi> itens;
/**
 * Constructor 'Vendedor', constrói um novo objecto com uma lista de items vazia
 * */
    public Vendedor() {
        this.itens = itens;
    }

/**
 * Método responsável por actualizar os itens disponíveis do Vendedor
 *
 * @param itens representa a lista de itens disponíveis
 * */
    public void setItens(ArrayList<ItemHeroi> itens) {
        this.itens = itens;
    }

    /**
     * Printa a lista de itens (inventário)
     * */

    public void imprimirInventario() {
        int i = 0;
        for (ItemHeroi item : itens) {
            i++;
            System.out.print(i + " - ");
            if (item instanceof Arma) {
                item.mostrarDetalhes();
                System.out.println();
            }
            if (item instanceof PocaoHP){
                item.mostrarDetalhes();
                System.out.println();
            }
        }

    }

    /**
     * Método responsável por vender umm item ao Herói
     *
     * @param heroi a que vende um item
     * */

    public void vender(Heroi heroi) {
        Scanner input = new Scanner(System.in);

        System.out.println("Qual item desejas comprar?");

        int escolha = input.nextInt();

        int itemIndice = escolha - 1;


        if (itemIndice >= 0 && itemIndice < itens.size()) {

            ItemHeroi item = itens.get(itemIndice);

            if (item instanceof Arma arma) {

                boolean permitHeroi = false;

                for (String heroiTipo : item.getTipoHeroi()) {
                    if (heroiTipo.equalsIgnoreCase(heroi.getClass().getSimpleName())) {
                        permitHeroi = true;
                        break;
                    }
                }
                if (permitHeroi) {
                    if (heroi.getOuro() >= item.getPreco()) {
                        heroi.setOuro(heroi.getOuro() - item.getPreco());
                        heroi.setArma(arma);
                        System.out.println("Arma comprada: " + item.getNome());
                        System.out.println();
                        itens.remove(item);

                    } else {
                        System.out.println("Não tens ouro suficiente para comprar a arma.");
                    }
                } else {
                    System.out.println("Esta arma não é adequada para o teu tipo de herói.");
                }
            }

            else if (item instanceof PocaoHP pocaoHP) {
                if (heroi.getOuro() >= item.getPreco()) {
                    heroi.setOuro(heroi.getOuro() - item.getPreco());
                    heroi.adicionarPocaoHP(pocaoHP);
                    System.out.println("Poção comprada: " + item.getNome());
                    System.out.println();
                    itens.remove(item);
                } else {
                    System.out.println("Não tens ouro suficiente para comprar a poção.");
                }
            } else {
                System.out.println("A compra não pode ser efetuada!");
            }
        }
    }


}
