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
public class Menu {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        BufferedReader entrada;

        entrada = new BufferedReader (
                new InputStreamReader(System.in));


        try{

            System.out.println("1 : Adicao");
            System.out.println("2 : Subtracao");
            System.out.println("3 : Multiplicacao");
            System.out.println("4 : Divisão");

            System.out.println("Qual a opcao desejada ? ");

            int opcao = Integer.parseInt(entrada.readLine());

            switch (opcao)
            {

                case 1: modAdiciona(); break;
                case 2: modSubtrai(); break;
                case 3: modMultiplica(); break;
                case 4: modDivide(); break;
                default: System.out.println("Fim do programa");


            }
        } catch (Exception erro)
        {
            System.out.println("Ocorreu um erro de leitura");
        }

    }


    static void modAdiciona()
    {
        BufferedReader entraSoma;
        entraSoma = new BufferedReader(new InputStreamReader(System.in));


    try {

        System.out.println("Qual o primeiro numero ? ");
        float numero1  = Float.parseFloat(entraSoma.readLine());

        System.out.println("Qual o segundo numero ? ");
        float numero2  = Float.parseFloat(entraSoma.readLine());

        float resultado = numero1 + numero2;
        System.out.println("Soma = "+resultado);

       } catch (Exception erro)
       {
           System.out.println("Ocorreu um erro de leitura!");

       }

    }

    static void modSubtrai()
    {

        BufferedReader entraSub;
        entraSub = new BufferedReader(new InputStreamReader(System.in));

    try {

        System.out.println("Qual o primeiro numero ? ");
        float numero1 = Float.parseFloat(entraSub.readLine());

        System.out.println("Qual o segundo numero ? ");
        float numero2 = Float.parseFloat(entraSub.readLine());

        float resultado = numero1 - numero2;

        System.out.println("Resultado"+resultado);

    } catch (Exception Erro)
    {
System.out.println("Ocorreu um  erro de leitura");

    }

    }


    static void modMultiplica()
    {

        BufferedReader entraMult;

        entraMult =  new BufferedReader(new InputStreamReader(System.in));


        try{


                System.out.println("Qual é o primeiro valor ? ");
                float numero1 = Float.parseFloat(entraMult.readLine());
                System.out.println("Qual é o segundo valor ? ");
                float numero2 = Float.parseFloat(entraMult.readLine());

                float resultado = numero1 * numero2;

                System.out.println("Resultado = "+resultado);

        
        }catch (Exception Erro)
        {

            System.out.println("Erro na leitura do arquivo");


        }
    }

    static void modDivide()
    {


        BufferedReader entraDiv;


        entraDiv = new BufferedReader (new InputStreamReader(System.in));


        try{

            System.out.println("Qual o primeiro valor ? ");
            float numero1 = Float.parseFloat(entraDiv.readLine());

            System.out.println("Qual o segundo valor ? ");
            float numero2 = Float.parseFloat (entraDiv.readLine());
            

            float resultado = (numero1/numero2);
            

            System.out.println("Resultado = "+ resultado);



        }catch (Exception erro ){

            System.out.println("Erro na leitura do dados ! ");
        }


     }

}