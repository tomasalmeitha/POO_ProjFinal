package Jogo;

import Entidades.*;
import Itens.Arma;
import Itens.ItemHeroi;
import Itens.PocaoHP;

import java.util.ArrayList;
import java.util.Scanner;

public class Jogo {
    public static void main(String[] args) {
        labirinto();
    }
    boolean valid = true;

    public static void labirinto() {
        Scanner input = new Scanner(System.in);
        boolean estaVivo = true;
        Heroi heroi;

        do {
            // Escolha do tipo de herói
            System.out.println("Escolha o tipo de herói: (1) Cavaleiro, (2) Feiticeiro, (3) Arqueiro");
            int heroChoice = input.nextInt();

            switch (heroChoice) {
                case 1:
                    heroi = new Cavaleiro();
                    break;
                case 2:
                    heroi = new Feiticeiro();
                    break;
                case 3:
                    heroi = new Arqueiro();
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente!");
                    heroi = null;
                    break;
            }
        } while (heroi == null);

/*********************************************************************************************************************/

            // Escolha dificuldade do jogo
            int difficultyChoice;
            int pontosCriacao;
            int ouro;

        do {
            System.out.println("Escolha a dificuldade: (1) Fácil, (2) Difícil");
            difficultyChoice = input.nextInt();

            switch (difficultyChoice) {
                case 1:
                    pontosCriacao = 300;
                    ouro = 20;
                    break;
                case 2:
                    pontosCriacao = 220;
                    ouro = 15;
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente!");
                    pontosCriacao = 0;
                    ouro = 0;
                    break;
            }
        } while (pontosCriacao == 0);



/*********************************************************************************************************************/

            // Distribuição dos pontos de criação de personagem
            int vida = 0;
            int forca = 0;

         do {
                System.out.println("Tem " +pontosCriacao+ " pontos restantes!");
                System.out.println("Distribua os pontos de criação de personagem (vida, força)");
                System.out.println("Cada ponto de vida vale um ponto de criação e cada ponto de força vale 5 pontos!");

                System.out.print("Pontos de vida(HP): ");
                int vidaPoints = input.nextInt();
                System.out.print("Pontos de força: ");
                int forcaPoints = input.nextInt();

                if (vidaPoints < 0 || forcaPoints < 0) {
                    System.out.println("Pontos inválidos. Tente novamente!");
                    return;
                }

                if (vidaPoints + forcaPoints * 5 > pontosCriacao) {
                    System.out.println("Pontos de criação excedidos. Tente novamente!");
                    return;
                }

                if(vidaPoints > pontosCriacao && forcaPoints > pontosCriacao){
                    System.out.println("Pontos de criação excedidos. Tente novamente!");
                    return;
                }

                vida += vidaPoints;
                forca += forcaPoints;
                pontosCriacao -= vidaPoints + forcaPoints * 5;

            } while (pontosCriacao != 0);

        /*********************************************************************************************************************/
            // Atribuição dos atributos à personagem
            heroi.setHP(vida);
            heroi.setForca(forca);

            // Atribuição do ouro à personagem
            heroi.setOuro(ouro);

            System.out.print("Insira o seu nome: ");
            String nome = input.next();
            heroi.setNome(nome);

            System.out.println("Você está pronto para iniciar o jogo!");
            System.out.println("Herói: " + heroi.getNome());
            System.out.println("Vida: " + heroi.getHP());
            System.out.println("Força: " + heroi.getForca());
            System.out.println("Ouro: " + heroi.getOuro());


        /*********************************************************************************************************************/

        //Instanciamento de items para o inventário
        ArrayList<String> tipoKnight = new ArrayList<>();
        tipoKnight.add("Cavaleiro");

        ArrayList<String> tipoWizard = new ArrayList<>();
        tipoWizard.add("Feiticeiro");

        ArrayList<String> tipoArcher = new ArrayList<>();
        tipoArcher.add("Arqueiro");

        ArrayList<String> tipoAll = new ArrayList<>();
        tipoAll.add("Cavaleiro");
        tipoAll.add("Feiticeiro");
        tipoAll.add("Arqueiro");

        Arma espada = new Arma("Espada Aragorn", 10, tipoKnight, 25);
        Arma bastão = new Arma("Bastão de Mago", 10, tipoWizard, 40);
        Arma adaga = new Arma("Adaga Robin", 5, tipoArcher, 15);
        PocaoHP elixirDaVida = new PocaoHP("Elixir da Vida", 30, tipoAll, 25);
        Arma arco = new Arma("Arco Legolas", 10, tipoArcher, 30);
        Arma machado = new Arma("Machado Gimli", 15, tipoKnight, 35);
        Arma varinha = new Arma("Varinha Dumbledore", 8, tipoWizard, 20);
        Arma lanca = new Arma("Lança Uruk Hai", 12, tipoKnight, 30);
        PocaoHP pocaoCura = new PocaoHP("Poção Wiggenweld (Cura)", 20, tipoAll, 25);
        Arma espadaLonga = new Arma("Espada William Wallace", 14, tipoKnight, 30);
        Arma cajado = new Arma("Cajado Gandalf", 8, tipoWizard, 25);
        PocaoHP pocaoEnergia = new PocaoHP("Poção Polissuco (Energia)", 25, tipoAll, 25);
        Arma arcoArabe = new Arma("Arco Árabe", 9, tipoArcher, 25);
        Arma punhal = new Arma("Punhal Assassino", 6, tipoArcher, 18);
        PocaoHP elixirForca = new PocaoHP("Elixir de Sangue de Dragão (Força)", 30, tipoAll, 25);
        Arma cajadoElemental = new Arma("Cajado Saruman", 12, tipoWizard, 30);
        Arma lancaRamses = new Arma("Lança Ramsés", 16, tipoKnight, 35);


        ArrayList<ItemHeroi> itens = new ArrayList<>();

        itens.add(espada);
        itens.add(bastão);
        itens.add(adaga);
        itens.add(elixirDaVida);
        itens.add(arco);
        itens.add(machado);
        itens.add(varinha);
        itens.add(lanca);
        itens.add(pocaoCura);
        itens.add(espadaLonga);
        itens.add(cajado);
        itens.add(pocaoEnergia);
        itens.add(arcoArabe);
        itens.add(punhal);
        itens.add(elixirForca);
        itens.add(cajadoElemental);
        itens.add(lancaRamses);


        Vendedor vendedor = new Vendedor(itens);
        vendedor.imprimirInventario();

        /*********************************************************************************************************************/

        System.out.println("Bem vindo, " +heroi.getNome()+ " à Lenda dos Defensores de Atena!");
        System.out.println();
        System.out.println("Terás que percorrer as 12 casas do Zodiaco e vencer os 12 Cavaleiros de Ouro!");

        System.out.println("Saga, o cavaleiro de Gémeos, um individuo tirânico, cerebral e louco, sequestrou a nossa adorada princesa Atena no Santo Santuário do Zodiaco e precisamos de ti para a recuperar!");

        System.out.println("Toma cuidado! Os Cavaleiros de Ouro são guerreiros extremamente poderosos e hábeis, outrora eram defensores de Atena e do nosso reino, mas Lémur enfeitiçou os e estão neste momento sob o controlo de Saga! ");
        System.out.println();
        System.out.println("Irás percorrer esta jornada com Seiya de Pégasus, Shiryu de Dragão, Hyoga de Cisne e Shun de Andrómeda como teus fieis companheiros!");
        System.out.println();
        System.out.println("Boa sorte e que Zeus te acompanhe!");

    //Inicio
        System.out.println("Existe uma arca perto da escadaria da primeira casa do Zodiaco, desejas abrir?");
        System.out.println("(1) Sim, (2) Não");
        int escolha = input.nextInt();

        switch (escolha) {
            case 1:
                System.out.println("Encontraste uma poção de cura!");
                PocaoHP pocaoHP = new PocaoHP("Poção de Vida", 5, tipoAll, 25);
                heroi.adicionarPocaoHP(pocaoHP);
                break;
            case 2:
                System.out.println("Decidiste não abrir!");
                break;

        }
        //Vendedor
        



    }
}
