package Exemplos;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.*;

/**
 *
 * @author robson
 */
public class Entrada {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here


        BufferedReader entrada;

        entrada = new BufferedReader(new InputStreamReader (System.in));

        String nome;

        try
        {

        System.out.println("Qual o seu nome?");
        nome = entrada.readLine();
        System.out.println(nome);

        }
        catch (Exception e)

        {

            System.out.println("Ocorreu um erro durante a leitura");
        }

    }

}
