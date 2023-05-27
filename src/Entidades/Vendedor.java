package Entidades;

import Itens.Arma;
import Itens.ItemHeroi;
import Itens.PocaoHP;

import java.util.ArrayList;
import java.util.Scanner;

public class Vendedor {
    private ArrayList<ItemHeroi> itens;

    public Vendedor() {
        this.itens = itens;
    }

    public void setItens(ArrayList<ItemHeroi> itens) {
        this.itens = itens;
    }

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


    public void vender(Heroi heroi) {
        Scanner input = new Scanner(System.in);

        System.out.println("Qual item desejas comprar?");

        int escolha = input.nextInt();

        int itemIndex = escolha - 1;


        if (itemIndex >= 0 && itemIndex < itens.size()) {

            ItemHeroi item = itens.get(itemIndex);

            if (item instanceof Arma arma) {

                boolean allowedHeroi = false;

                for (String heroiType : item.getTipoHeroi()) {
                    if (heroiType.equalsIgnoreCase(heroi.getClass().getSimpleName())) {
                        allowedHeroi = true;
                        break;
                    }
                }
                if (allowedHeroi) {
                    if (heroi.getOuro() >= item.getPreco()) {
                        heroi.setOuro(heroi.getOuro() - item.getPreco());
                        heroi.setArma(arma);
                        System.out.println("Arma comprada: " + item.getNome());
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
                } else {
                    System.out.println("Não tens ouro suficiente para comprar a poção.");
                }
            } else {
                System.out.println("A compra não pode ser efetuada!");
            }
        }
    }


}
