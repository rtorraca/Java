package SobrecargaMetodos;

// Fig. 6.13: MethodOverload.java
// Declaração de Métodos Sobrecarregados
// pag 174

public class MethodOverload 
{
   // teste de métodos square sobrecarregados
   public void testOverloadedMethods()
   {
      System.out.printf( "Square de inteiros 7 é .: %d\n", square( 7 ) );
      System.out.printf( "Square de flutuante 7.5 é .: %f\n", square( 7.5 ) );
   } // fim dos métodos sobrecarregadoss
   
   // square método sobrecarregado com inteiro 
   public int square( int intValue )
   {
      System.out.printf( "\nCalled square com argumento inteiro.: %d\n", 
         intValue );
      return intValue * intValue;
   } // fim do método square com inteiro

   // método com argumento do tipo double 
   public double square( double doubleValue )
   {
      System.out.printf( "\nCalled square com argumento double.: %f\n",
         doubleValue );
      return doubleValue * doubleValue;
   } // end method square with double argument
} // end class MethodOverload

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