/*
Vai fazer sorteios de valores de 1 à 6 em 6000 vezes, 
e irá contar quantas vezes  cada número aparece

pág. 166
 */

package JogoDados;

import java.util.Random;
/**
 *
 * @author robson
 */
public class RollDie {
    
public static void main(String args[])
{
    
    Random randomNumbers = new Random();
    
    int frequency1 = 0 ;/*número 1 aparecerá*/
    int frequency2 = 0 ;/*número 2 aparecerá*/
    int frequency3 = 0 ;/*número 3 aparecerá*/
    int frequency4 = 0 ;/*número 4 aparecerá*/
    int frequency5 = 0 ;/*número 5 aparecerá*/
    int frequency6 = 0 ;/*número 6 aparecerá*/
    
    int face;/* armazena o valor sorteado recentemente*/

for (int roll =1; roll <=6000; roll++){
    
    face = 1 +randomNumbers.nextInt(6);

switch(face)
{
    case 1:
        ++frequency1;
        break;
        
    case 2:
        ++frequency2;
        break;
        
    case 3:
        ++frequency3;
        break;
        
    case 4:
        ++frequency4;
        break;
          
    case 5:
        ++frequency5;
        break;
        
   case 6:
        ++frequency6;
        break;        
         
        
}//fim do switch


}//fim do final

System.out.println("Face\tFrequency");//Cabeçalho de saída
System.out.printf("1\t%d\n2\t%d\n3\t%d\n4\t%d\n5\t%d\n6\t%d\n", frequency1,
        frequency2,frequency3,frequency4,frequency5,frequency6);
}//fim da main
    
    
}//fim da classe
