package Jogo;

import Entidades.*;
import Itens.Arma;
import Itens.ItemHeroi;
import Itens.PocaoHP;

import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

import static Jogo.Signos.*;

/**
 * O programa desenvolvido é um jogo baseado na Lenda dos Cavaleiros do Zodiaco e tenta ser o mais fiél possível à história da série Anime criada em 1988.
 * O utilizador/jogador pode explorar um labirinto, que é no fundo o seu percurso até à última casa do Zodiaco em que tem de enfrentar o Cavaleiro de Gémeos, Saga, para poder socorrer a princesa Atena.
 * Cada casa, terá um Cavaleiro de Ouro (NPC), guardião de cada casa do Zodiaco ou poderá ser uma 'casa tesouro' com poções e armaduras que lhe aumentam pontos de vida.
 * Poderá também interagir com um Vendedor que lhe vende artefactos e poções.
 * Este jogo oferece também diferentes tipos de Heróis (Cavaleiro, Feiticeiro e Arqueiro) assim como níveis de dificuldade associados.*/
public class Jogo {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        boolean victory = false;
        boolean playAgain = false;

        Heroi heroi;
        do {
            do {
                // Escolha do tipo de herói
                System.out.println();
                System.out.println("Escolha o tipo de herói: (1) Cavaleiro, (2) Feiticeiro, (3) Arqueiro");
                int heroChoice = input.nextInt();
                // Validação do tipo escolhido
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

            // Escolha da dificuldade do jogo
            int difficultyChoice;
            int pontosCriacao;
            int ouro;

            do {
                System.out.println("Escolha a dificuldade: (1) Fácil, (2) Difícil");
                difficultyChoice = input.nextInt();
                // Validação do input de dificuldade
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
                System.out.println();
                System.out.println("Tem " + pontosCriacao + " pontos restantes!");
                System.out.println();
                System.out.println("Distribua os pontos de criação de personagem (vida, força)");
                System.out.println();
                System.out.println("Cada ponto de vida vale um ponto de criação e cada ponto de força vale 5 pontos!");
                System.out.println();


                int vidaPoints;
                //Atribuição dos pontos de vida(HP) e pontos de força. Validação dos valores inseridos.
                do {
                    System.out.print("Pontos de vida(HP): ");
                    vidaPoints = input.nextInt();

                    if (vidaPoints > pontosCriacao) {
                        System.out.println("Pontos de criação excedidos. Tente novamente!");

                    } else if (vidaPoints < 0) {
                        System.out.println("Pontos inválidos. Tente novamente!");
                    }

                } while (vidaPoints > pontosCriacao || vidaPoints < 0);

                int tempPoints = pontosCriacao - vidaPoints;
                int forcaPoints = tempPoints / 5;

                vida += vidaPoints;
                forca += forcaPoints;
                pontosCriacao -= vidaPoints + forcaPoints * 5;

            } while (pontosCriacao != 0);

            /*********************************************************************************************************************/

            // Atribuição dos atributos à personagem baseado no grau de dificuldade escolhido
            heroi.setHP(vida);
            heroi.setForca(forca);

            // Atribuição do ouro à personagem
            heroi.setOuro(ouro);

            System.out.print("Insira o seu nome: ");
            String nome = input.next();
            heroi.setNome(nome);
            System.out.println();
            System.out.println("Está pronto para iniciar o jogo!");
            System.out.println("Herói: " + heroi.getNome());
            System.out.println("Vida: " + heroi.getHP());
            System.out.println("Força: " + heroi.getForca());
            System.out.println("Ouro: " + heroi.getOuro());
            System.out.println("Nível: " +heroi.getNivel());

            /*********************************************************************************************************************/

            //Introdução do jogo
            System.out.println();
            System.out.println("Bem vindo, " + heroi.getNome() + " à Lenda dos Defensores de Atena!");
            System.out.println();
            System.out.println("Terás que percorrer as 12 casas do Zodiaco e vencer os 12 Cavaleiros de Ouro!");

            System.out.println("Saga, o cavaleiro de Gémeos, um individuo tirânico, cerebral e louco, sequestrou a nossa adorada princesa Atena no Santo Santuário do Zodiaco e precisamos de ti para a recuperar!");

            System.out.println("Toma cuidado! Os Cavaleiros de Ouro são guerreiros extremamente poderosos e hábeis, outrora eram defensores de Atena e do nosso reino, mas Lémur enfeitiçou os e estão neste momento sob o controlo de Saga! ");
            System.out.println();
            System.out.println("Irás percorrer esta jornada com Seiya de Pégasus, Shiryu de Dragão, Hyoga de Cisne e Shun de Andrómeda como teus fieis companheiros!");
            System.out.println();
            System.out.println("Boa sorte e que Zeus te acompanhe!");
            System.out.println();
            System.out.println();

            //Instanciamento do labirinto passando o objecto 'heroi' como parâmetro
            labirinto(heroi);
            //Condição que pergunta ao jogador se deseja jogar novamente
            System.out.println();
            System.out.println("Fim do Jogo!");
            System.out.println("Deseja jogar novamente? (1) Sim, (2) Não");

            int jogoNovoChoice = input.nextInt();

            if (jogoNovoChoice == 1){
                playAgain = true;
            }
            else if (jogoNovoChoice == 2){
                System.out.println();
                System.out.println("Até à próxima!");
                playAgain = false;
            }

        } while(playAgain);
    }

    /**
     * Este método é o labirinto do jogo, onde o jogador enfrenta os adversários e interage com o vendedor
     * @param heroi representa a personagem do jogador.
     */
        public static void labirinto(Heroi heroi) {

            Scanner input = new Scanner(System.in);


            //Instanciamento de items para o inventário do Vendedor
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


            //Instanciamento de objectos: uma poção de vida, a personagem Vendedor e o seu inventário
            //Assim como a variável 'victory' responsável por atribuir a vitória ao jogador e o aparecimento do Vendedor antes do jogador entrar em alguma casa
            PocaoHP pocaoHP1 = new PocaoHP("Poção de Vida", 5, tipoAll, 35);
            Vendedor vendedor1 = new Vendedor();
            vendedor1.setItens(itens);
            boolean victory = true;
            boolean returnToCase1 = true;
            int i = 1;
            int escolha2 = 1;
            do {
                i++;
                switch (escolha2) {

                    case 1:
                        // Vendedor
                        System.out.println("Antes de avançar, deseja comprar algum item? ");
                        System.out.println("(1) Sim, (2) Não");
                        int escolha3 = input.nextInt();

                        if (escolha3 == 1) {
                            vendedor1.imprimirInventario();
                            vendedor1.vender(heroi);
                        }
                        escolha2 = i;
                        break;

                    case 2:
                        //Primeiro confronto
                        function1();
                        System.out.println();
                        System.out.println("Chegou à casa de Shion de Carneiro!");
                        System.out.println("Shion, um guerreiro sereno, honrado e nobre com uma natureza valente, determinada e impulsiva.");
                        System.out.println("Prepara-te para combater!");
                        NPC Shion = new NPC("Shion", 100, 20);
                        if (!heroi.atacar(Shion)) {
                            victory = false;
                            returnToCase1 = false;
                            break;
                        }
                        heroi.nivelUp();
                        escolha2 = 1;
                        break;

                    case 4:
                        //Segundo confronto
                        function2();
                        System.out.println();
                        System.out.println("Chegou à casa de Aldebaran de Touro!");
                        System.out.println("Aldebaran, um guerreiro divertido, humilde e aventureiro com bom coração, mas forte, atlético e com uma força inigualável!");
                        System.out.println("Prepara-te para combater!");
                        NPC Aldebaran = new NPC("Aldebaran", 10, 10);
                        if (!heroi.atacar(Aldebaran)) {
                            victory = false;
                            returnToCase1 = false;
                            break;
                        }
                        heroi.nivelUp();
                        escolha2 = 1;
                        break;

                    case 6:
                        //Terceiro confronto
                        function3();
                        System.out.println();
                        System.out.println("Chegou à casa de Saga de Gémeos!");
                        System.out.println("Saga, um guerreiro de dupla personalidade, oscilando entre extremos do bem e do mal. Dentro dele, esses opostos estavam sempre a lutar entre si. Depois de ter o seu coração purificado, ele mesmo tira a sua própria vida!");
                        System.out.println();
                        System.out.println("Esta casa aparenta não ter ninguém, no entanto, encontraste um baú no interior da casa, desejas abrir?");
                        System.out.println("(1) Sim, (2) Não");
                        int escolhaa = input.nextInt();

                        if (escolhaa == 1) {
                            System.out.println("Encontraste uma poção de cura!");

                            int heroiHP = heroi.getHP();
                            System.out.println("HP before potion: " +heroiHP);
                            heroi.adicionarPocaoHP(pocaoHP1);
                            heroi.setHP(heroi.getHP() + pocaoHP1.getCura());
                            int heroiHP2 = heroi.getHP();
                            System.out.println("HP after potion: " +heroiHP2);
                            heroi.removePocaoHP(pocaoHP1);
                            int heroiHP3 = heroi.getHP();
                            System.out.println("HP after removing potion: " +heroiHP3);
                            System.out.println("A poção de cura restaurou " + pocaoHP1.getCura() + " de HP.");
                        } else {
                            System.out.println("Decidiste não abrir!");
                        }
                        escolha2 = 1;
                        break;

                    case 8:
                        //Quarto confronto
                        function4();
                        System.out.println();
                        System.out.println("Chegou à casa de Schiller de Caranguejo!");
                        System.out.println("Cuidado, Shiller é um guerreiro extremamente poderoso! Considerado o Máscara da Morte tem uma personalidade violenta, sanguinário, forte e sádico...");
                        System.out.println("Prepara-te para combater!");
                        NPC Schiller = new NPC("Schiller", 10, 5);
                        if (!heroi.atacar(Schiller)) {
                            victory = false;
                            returnToCase1 = false;
                            break;
                        }
                        heroi.nivelUp();
                        escolha2 = 1;
                        break;

                    case 10:
                        //Quinto confronto
                        function5();
                        System.out.println();
                        System.out.println("Chegou à casa de Aiolia de Leão!");
                        System.out.println("Aiolia, é um dos mais nobres e valentes cavaleiros do Zodiaco, sempre disposto a lutar pela justiça!");
                        System.out.println("Prepara-te para combater!");
                        NPC Aiolia = new NPC("Aiolia", 10, 5);
                        if (!heroi.atacar(Aiolia)) {
                            victory = false;
                            returnToCase1 = false;
                            break;
                        }
                        heroi.nivelUp();
                        escolha2 = 1;
                        break;

                    case 12:
                        //Sexto confronto
                        function6();
                        System.out.println();
                        System.out.println("Chegou à casa de Shaka de Virgem!");
                        System.out.println("Shaka é um homem que possui grande poder, sabedoria e conhecimento, o que o fazem ser admirado e respeitado pelos seus companheiros!");
                        System.out.println("Prepara-te para combater!");
                        NPC Shaka = new NPC("Shaka", 15, 5);
                        if (!heroi.atacar(Shaka)) {
                            victory = false;
                            returnToCase1 = false;
                            break;
                        }
                        heroi.nivelUp();
                        escolha2 = 1;
                        break;

                    case 14:
                        //Sétimo confronto
                        function7();
                        System.out.println();
                        PocaoHP armBalanca = new PocaoHP("Armadura de Balança", 0, tipoAll, 45);
                        //Sétimo confronto
                        System.out.println("Chegou à casa de Dohko de Balança!");
                        System.out.println("Dohko é uma pessoa calma, disciplinada, leal e equilibrada, algo que lhe fez valer o titulo de Cavaleiro que rege o Equilíbrio e a Harmonia entre os Cavaleiros de Ouro!");
                        System.out.println();
                        System.out.println("Ao entrar na casa de Balança, deparas te com uns artefactos no centro!");
                        System.out.println("Desejas investigar?");
                        System.out.println("(1) Sim, (2) Não");
                        int opcao2 = input.nextInt();

                        if (opcao2 == 1) {
                            System.out.println("Adquiriste a Armadura de Balança e 20 moedas de ouro!");
                            heroi.adicionarPocaoHP(armBalanca);
                            heroi.setHP(heroi.getHP() + armBalanca.getCura());
                            heroi.setOuro(heroi.getOuro() + 20);
                            System.out.println();
//
                            System.out.println("A Armadura de Balança " + armBalanca.getCura() + " de HP.");
                        } else {
                            System.out.println("Decidiste não abrir!");
                        }
                        escolha2 = 1;
                        break;

                    case 16:
                        //Oitavo confronto
                        function8();
                        System.out.println();
                        System.out.println("Chegou à casa de Milo de Escorpião!");
                        System.out.println("Milo tem uma personalidade ativa e arrogante, mas apesar disso, Milo é um homem muito nobre e possui um grande senso de justiça e muito hábil!");
                        System.out.println("Prepara-te para combater!");
                        NPC Milo = new NPC("Milo", 15, 5);
                        if (!heroi.atacar(Milo)) {
                            victory = false;
                            returnToCase1 = false;
                            break;
                        }
                        heroi.nivelUp();
                        escolha2 = 1;
                        break;

                    case 18:
                        //Nono confronto
                        function9();
                        System.out.println();
                        PocaoHP armSagitario = new PocaoHP("Armadura de Sagitário", 0, tipoAll, 45);
                        //Nono confronto
                        System.out.println("Chegou à casa de Iuka de Sagitário!");
                        System.out.println("Iuka é um cavaleiro bondoso e gentil(até demais), mas não deixa de cumprir seu dever!");
                        System.out.println();
                        System.out.println("Ao entrar na casa de Sagitário, depara se que está uma armadura no centro!");
                        System.out.println("Deseja utilizar?");
                        System.out.println("(1) Sim, (2) Não");
                        int opcao3 = input.nextInt();

                        if (opcao3 == 1) {
                            System.out.println("Adquiriste a Armadura de Sagitário!");
                            heroi.adicionarPocaoHP(armSagitario);

                            heroi.setHP(heroi.getHP() + armSagitario.getCura());

                            System.out.println("A Armadura de Sagitário " + armSagitario.getCura() + " de HP.");
                        } else {
                            System.out.println("Decidiste não abrir!");
                        }
                        escolha2 = 1;
                        break;

                    case 20:
                        //Décimo confronto
                        function10();
                        System.out.println();
                        System.out.println("Chegou à casa de Shura de Capricórnio!");
                        System.out.println("Shura é um cavaleiro de ouro bastante poderoso, com uma facilidade espantosa em lançar sua fortíssima Excalibur na velocidade da luz!");
                        System.out.println("Prepara-te para combater!");
                        NPC Shura = new NPC("Shura", 15, 5);
                        if (!heroi.atacar(Shura)) {
                            victory = false;
                            returnToCase1 = false;
                            break;
                        }
                        heroi.nivelUp();
                        escolha2 = 1;
                        break;

                    case 22:
                        //Décimo primeiro confronto
                        function11();
                        System.out.println();
                        System.out.println("Chegou à casa de Camus de Aquário!");
                        System.out.println("Camus é um cavaleiro com uma serenidade e frieza inigualável no campo de batalha. Camus é inflexível quando acredita em algo, mas permanece sempre calmo e calculista!");
                        System.out.println("Prepara-te para combater!");
                        NPC Camus = new NPC("Camus", 15, 5);
                        if (!heroi.atacar(Camus)) {
                            victory = false;
                            returnToCase1 = false;
                            break;
                        }
                        heroi.nivelUp();
                        escolha2 = 1;
                        break;

                    case 24:
                        //Décimo segundo confronto
                        function12();
                        System.out.println();
                        System.out.println("Chegou à casa de Afrodite de Peixes!");
                        System.out.println("Afrodite possui habilidades ofensivas e defensivas, é capaz de remover os sentidos de seus oponentes e de destruir Armaduras de Bronze facilmente!");
                        System.out.println("Prepara-te para combater!");
                        NPC Afrodite = new NPC("Afrodite", 15, 1);
                        if (!heroi.atacar(Afrodite)) {
                            returnToCase1 = false;
                            break;
                        }
                        heroi.nivelUp();
                        escolha2 = 1;
                        break;

                    case 26:
                        //Final boss
                        function3();
                        System.out.println();
                        System.out.println("Confronto final contra Saga de Gémeos!");
                        System.out.println("O destino de Atena está nas tuas mãos!");
                        System.out.println("Prepara-te bem para a batalha!!");
                        NPC Saga = new NPC("Saga", 20, 1);
                        if (!heroi.atacar(Saga)) {
                            victory = false;
                            returnToCase1 = false;
                            break;
                        }
                        heroi.nivelUp();
                        returnToCase1 = false;
                        break;

                    default:
                        escolha2 = i;
                        break;

                }

            } while (returnToCase1);
            //No caso do jogador ganhar
            if (victory) {
                System.out.println();
                System.out.println();
                System.out.println("A batalha pelas 12 casas do Zodiaco terminou e tu saiste vencedor!");
                System.out.println("És o guerreiro lendário que a profecia falava!");
                System.out.println("Parabéns, " +heroi.getNome()+ "!!!");
                System.out.println("Conseguiste resgatar a princesa Atena a tempo e a paz voltou ao mundo!");
            }
        }


}


