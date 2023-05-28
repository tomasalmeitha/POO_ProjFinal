package Jogo;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Signos {

    public static void function1() {
        try {
            File Ficheiro = new File("src/carneiro.txt");
            Scanner in = new Scanner(Ficheiro);
            while (in.hasNextLine()) {
                String linha = in.nextLine();
                System.out.println(linha);
            }
            in.close();
        } catch (FileNotFoundException exc) {
            System.out.println("Ficheiro não encontrado!");
        }
    }

    public static void function2() {
        try {
            File Ficheiro = new File("src/touro.txt");
            Scanner in = new Scanner(Ficheiro);
            while (in.hasNextLine()) {
                String linha = in.nextLine();
                System.out.println(linha);
            }
            in.close();
        } catch (FileNotFoundException exc) {
            System.out.println("Ficheiro não encontrado!");
        }
    }

    public static void function3() {
        try {
            File Ficheiro = new File("src/gemeos.txt");
            Scanner in = new Scanner(Ficheiro);
            while (in.hasNextLine()) {
                String linha = in.nextLine();
                System.out.println(linha);
            }
            in.close();
        } catch (FileNotFoundException exc) {
            System.out.println("Ficheiro não encontrado!");
        }
    }

    public static void function4() {
        try {
            File Ficheiro = new File("src/caranguejo.txt");
            Scanner in = new Scanner(Ficheiro);
            while (in.hasNextLine()) {
                String linha = in.nextLine();
                System.out.println(linha);
            }
            in.close();
        } catch (FileNotFoundException exc) {
            System.out.println("Ficheiro não encontrado!");
        }
    }

    public static void function5() {
        try {
            File Ficheiro = new File("src/leao.txt");
            Scanner in = new Scanner(Ficheiro);
            while (in.hasNextLine()) {
                String linha = in.nextLine();
                System.out.println(linha);
            }
            in.close();
        } catch (FileNotFoundException exc) {
            System.out.println("Ficheiro não encontrado!");
        }
    }

    public static void function6() {
        try {
            File Ficheiro = new File("src/virgem.txt");
            Scanner in = new Scanner(Ficheiro);
            while (in.hasNextLine()) {
                String linha = in.nextLine();
                System.out.println(linha);
            }
            in.close();
        } catch (FileNotFoundException exc) {
            System.out.println("Ficheiro não encontrado!");
        }
    }

    public static void function7() {
        try {
            File Ficheiro = new File("src/balanca.txt");
            Scanner in = new Scanner(Ficheiro);
            while (in.hasNextLine()) {
                String linha = in.nextLine();
                System.out.println(linha);
            }
            in.close();
        } catch (FileNotFoundException exc) {
            System.out.println("Ficheiro não encontrado!");
        }
    }

    public static void function8() {
        try {
            File Ficheiro = new File("src/escorpiao.txt");
            Scanner in = new Scanner(Ficheiro);
            while (in.hasNextLine()) {
                String linha = in.nextLine();
                System.out.println(linha);
            }
            in.close();
        } catch (FileNotFoundException exc) {
            System.out.println("Ficheiro não encontrado!");
        }
    }

    public static void function9() {
        try {
            File Ficheiro = new File("src/sagitario.txt");
            Scanner in = new Scanner(Ficheiro);
            while (in.hasNextLine()) {
                String linha = in.nextLine();
                System.out.println(linha);
            }
            in.close();
        } catch (FileNotFoundException exc) {
            System.out.println("Ficheiro não encontrado!");
        }
    }

    public static void function10() {
        try {
            File Ficheiro = new File("src/capricornio.txt");
            Scanner in = new Scanner(Ficheiro);
            while (in.hasNextLine()) {
                String linha = in.nextLine();
                System.out.println(linha);
            }
            in.close();
        } catch (FileNotFoundException exc) {
            System.out.println("Ficheiro não encontrado!");
        }
    }

    public static void function11() {
        try {
            File Ficheiro = new File("src/aquario.txt");
            Scanner in = new Scanner(Ficheiro);
            while (in.hasNextLine()) {
                String linha = in.nextLine();
                System.out.println(linha);
            }
            in.close();
        } catch (FileNotFoundException exc) {
            System.out.println("Ficheiro não encontrado!");
        }
    }

    public static void function12() {
        try {
            File Ficheiro = new File("src/peixes.txt");
            Scanner in = new Scanner(Ficheiro);
            while (in.hasNextLine()) {
                String linha = in.nextLine();
                System.out.println(linha);
            }
            in.close();
        } catch (FileNotFoundException exc) {
            System.out.println("Ficheiro não encontrado!");
        }
    }

}
