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
public class Temperatura {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        final int diasSemana = 7;
        float temperatura [] = new float [diasSemana];

        temperatura [0] = 19.0f;
        temperatura [1] = 23.0f;
        temperatura [2] = 21.0f;
        temperatura [3] = 25.0f;
        temperatura [4] = 22.0f;
        temperatura [5] = 20.0f;
        temperatura [6] = 24.0f;


        float aux;
        int min;

        for (int i=0; i<diasSemana-1; i++)
        {

            min=i;
            for (int j=i; i<diasSemana; i++)
            {
            if (temperatura[j]<temperatura[min])
            {
                min = j;
                aux = temperatura[min];
                temperatura[min] = temperatura[i];
                temperatura[i] = aux;

            }

            }
        }

System.out.println();



    }

}
