package Entidades;

import Itens.Arma;
import Itens.ItemHeroi;
import Itens.PocaoHP;

import java.util.ArrayList;
import java.util.Scanner;

public class Vendedor {
    private ArrayList<ItemHeroi> itens;

    public Vendedor() {
        this.itens = new ArrayList<>();
    }

    public void imprimirInventario(ArrayList<ItemHeroi> itens) {
        for (ItemHeroi item : itens) {
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
            System.out.println("www");
            ItemHeroi item = itens.get(itemIndex);
            System.out.println(itens.get(itemIndex).getNome());
            if (item instanceof Arma arma) {

                boolean allowedHeroi = false;

                for (String heroiType : item.getTipoHeroi()) {

                    System.out.println("Tipo de heroi a chegar: " +heroiType);
                    System.out.println("Cenas" +itens.getClass().getSimpleName());
                    if (heroiType.equalsIgnoreCase(itens.getClass().getSimpleName())) {
                        allowedHeroi = true;
                        break;
                    }

                }
                if (allowedHeroi) {
                    if (heroi.getOuro() >= item.getPreco()) {
                        heroi.setOuro(heroi.getOuro() - item.getPreco());
                        heroi.setArma(arma);
                        System.out.println("Arma comprada: " + item.getNome());

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
