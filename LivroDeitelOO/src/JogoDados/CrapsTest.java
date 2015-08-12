// Fig. 6.10: CrapsTest.java
// Application to test class Craps.

package JogoDados;

/**
 *
 * @author robson
 */


public class CrapsTest 
{
   public static void main( String args[] )
   {
       
       System.out.println("Regras do jogo \n");
       System.out.println("Vc lança dois dados\n");
       System.out.println("Quanto à soma destes, será analisado \n");
       System.out.println(" 1) Se no primeiro lançamento a soma for: 7 ou 11 vc Ganha! \n");
       System.out.println(" 2) Se a soma no primeiro lançamento for 2,3 ou 12 vc Perde! \n");
       System.out.println(" 3) Se as situações 1) e 2) não ocorrerem o jogo continua e vc acumula os valores\n");
       System.out.println(" 4) Com novos lançamentos, a soma não pode ser igual à 7, senão vc perde :( \n");
       System.out.println(" 5) Vc ganha quando a soma ser igual à sua pontuação acumulada no primeiro lançamento\n");
      /*Cria um método da classe Craps*/
       Craps game = new Craps();
      game.play(); // play one game of craps
   } // end main
} // end class CrapsTest

/**************************************************************************
 * (C) Copyright 1992-2005 by Deitel & Associates, Inc. and               *
 * Pearson Education, Inc. All Rights Reserved.                           *
 *                                                                        *
 * DISCLAIMER: The authors and publisher of this book have used their     *
 * best efforts in preparing the book. These efforts include the          *
 * development, research, and testing of the theories and programs        *
 * to determine their effectiveness. The authors and publisher make       *
 * no warranty of any kind, expressed or implied, with regard to these    *
 * programs or to the documentation contained in these books. The authors *
 * and publisher shall not be liable in any event for incidental or       *
 * consequential damages in connection with, or arising out of, the       *
 * furnishing, performance, or use of these programs.                     *
 *************************************************************************/