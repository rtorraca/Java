/*
 
 Fig. 6.9: Craps.java
 Craps class simulates the dice game craps.

 */

package JogoDados;

import java.util.Random;

public class Craps 
{
   // criar gerador de números aleatórios para uso no método rollDice
   private Random randomNumbers = new Random(); 
   //não é declarado no método! E sim uma variável de instância private static final da classe
   //e inicializado, isso permite criar um objeto Random que é reutilizado a cada 
   //chamada a rollDice, uma vez que esse objeto é static, ele também seria compartilhado
   //com todas as instâncias da classe Craps no programa

   // enumeração com constantes que representam o status do jogo
   private enum Status { CONTINUE, WON, LOST };

   // constantes que representam lançamentos comuns dos dados
   private final static int SNAKE_EYES = 2;
   private final static int TREY = 3;
   private final static int SEVEN = 7;
   private final static int YO_LEVEN = 11;
   private final static int BOX_CARS = 12;

   // plays one game of craps
   public void play()
   {
      int myPoint = 0; // pontos se não ganhar ou perder na primeira ralagem
      Status gameStatus; // pode conter CONTINUE, WON ou LOST

      int sumOfDice = rollDice(); // primeira rolagem dos dados

      // determina os status do jogo e a pontuação com base no primeiro lançamento
      switch ( sumOfDice ) 
      {
         case SEVEN: // ganha com 7 no primeiro lançamento
         case YO_LEVEN: // ganha com 11 no primeiro lançamento
            gameStatus = Status.WON;
            break;
         case SNAKE_EYES: // perde com 2 no primeiro lançamento
         case TREY: // perde com 3 no primeiro lançamento
         case BOX_CARS: // perde com 12 no primeiro lançamento
            gameStatus = Status.LOST;
            break;
         default: // não ganhou nem perdeu, então registra a pontuação         
            gameStatus = Status.CONTINUE; // jogo não terminou
            myPoint = sumOfDice; // informa a pontuação
            System.out.printf( "Ponto é %d\n", myPoint );
            break; // optional at end of switch
      } // end switch 

      // while game is not complete
      while ( gameStatus == Status.CONTINUE ) // not WON or LOST
      { 
         sumOfDice = rollDice(); // lança os dados novamente

         // determine game status
         if ( sumOfDice == myPoint ) // vitória por pontuação
            gameStatus = Status.WON;
         else
            if ( sumOfDice == SEVEN ) // perde obtendo 7 antes de atingir a pontuação
               gameStatus = Status.LOST;
      } // Fim do while

      // exibe uma mensagem ganhou ou perdeu
      if ( gameStatus == Status.WON )
         System.out.println( "Vc ganhou :)" );
      else
         System.out.println( "Vc perdeu :( " );
   } // end method play

   // roll dice, calculate sum and display results
   public int rollDice()
   {
      // pick random die values
      int die1 = 1 + randomNumbers.nextInt( 6 ); // Primeiro lançamento do Dado
      int die2 = 1 + randomNumbers.nextInt( 6 ); // Segundo  lançamento do Dado

      int sum = die1 + die2; // soma dos valores dos dados

      // exibe os resultados do lançamento
      System.out.printf( "Resultado dos lançamentos %d + %d = %d\n", 
         die1, die2, sum );

      return sum; // retorna aa soma dos dados
   } // end method rollDice
} // end class Craps

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