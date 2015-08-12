/*
Vai fazer sorteios de valores de 1 à 6 em 20 vezes, 
parecendo 4 sequência de 5 números

Pág. 165

 */

package JogoDados;

import java.util.Random;

/**
 *
 * @author robson
 */
public class SorteioNumeros {
    
    public static void main(String args[]){
       
        Random randomNumbers = new Random(); //gerador de número aleatório 
        int face;//armazena cada inteiro aleatório gerado
    
//faz loop 20 vezes
        
        for(int counter=1; counter<=20; counter++){
            //seleciona o inteiro aleatório entre 1 e 6
            
            face = 1 + randomNumbers.nextInt(100);
            System.out.printf("%d ",face);//exibe o valor gerado
        
//se o contador for divisível por 5, inicia uma nova linha de saída
            
            //Se o contador divisível por 5, inicia uma nova linha de saída
            //if(counter % 6 == 0)
                //System.out.println();
        }//for final
        
    
    }//fim de main
    
    
}//fim da classe RandomIntegers
