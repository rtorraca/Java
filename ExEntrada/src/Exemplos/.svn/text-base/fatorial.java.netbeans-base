/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Exemplos;
import java.io.*;

/**
 *
 * @author robson
 */
public class fatorial {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

    BufferedReader entrada;
    entrada = new BufferedReader (new InputStreamReader(System.in));

    try {

        System.out.println("Qual o numero?");
        int numero = Integer.parseInt (entrada.readLine());
        int fat = fatorial(numero);
        System.out.println("fatorial = "+ fat);
    }catch (Exception erro)
    {
        System.out.println("Ocorreu um erro na leitura");
    }

    }


static int fatorial (int num)
{
    
    int fat=1;
    
    for (int i=1;i<=num; i++)
    
    fat = fat*i;

    return fat;
    

}
}
