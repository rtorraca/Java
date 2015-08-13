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
public class Vetor {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here


         BufferedReader entrada;

         entrada = new BufferedReader(new InputStreamReader (System.in));

         int valor, soma=0;

         int [] vetor = new int [10];

         try
         {

         for (int i=0; i<vetor.length; i++)
         {

         System.out.println("Qual o primeiro valor?");
         vetor[i] = Integer.parseInt(entrada.readLine());
         soma = soma + vetor[i];

         }


        System.out.println("Soma dos valores "+soma);

         }
         catch (Exception e)
         {

             System.out.println("Ocorreu um erro durante a leitura!");

         }



    }

}
