/*
 * Criando e manipulando um objeto GradeBook
 * Exemplo de uso dos métodos Get e Set
 * Livro Deitel, Java Como Programar, pág:66
 */

package L3;

import java.util.Scanner;
/**
 *
 * @author robson
 */
public class GradeBookTest {
    
    /*Método main inicia a execução de programa*/
    public static void main(String[] args){
        
        
        /*Cria Scanner para obter a entrada a partir da janela de comando*/
        Scanner input = new Scanner(System.in);
        
        /*Cria um objeto GradeBook e o atribui a myGradeBook*/
        GradeBook myGradeBook = new GradeBook();
        
        /*Exibe o valor inicial de courseName*/
        System.out.printf("O nome do curso inicial é.: %s\n\n",myGradeBook.getCourseName());
        
        /*Solicita e lêe o nome do curso*/
        System.out.println("Por favor insira o nome do curso.: ");
        
        String theName= input.nextLine();/*Lêe uma linha de texto*/
        
        myGradeBook.setCourseName(theName);/*Configura o nome do curso*/
        System.out.println();/*Gera saída de uma linha em branco*/
        /*Exibe mensagem de boas-vindas depois de especificar o nome do curso*/
        myGradeBook.displayMessage();
        
        
    }//fim da main
    
}//fim da classe GradeBookTest
