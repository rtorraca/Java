/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package L2;

/**
 *
 * @author robson
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author robson
 */


import java.util.Scanner;

public class GradeBookTest {
    
    
    public static void main(String[] args){
        
        
        /*myGradeBook é criada com o resultado da Expressão de criação de instância da classe new GradeBook()*/
        GradeBook myGradeBook = new GradeBook();/*uma chamada para um construtor, semelhante à chamada ao método, mas é iniciado ao criar um objeto para iniciar seus dados*/
        /*Cria um objeto de classe Gradebook e a variável myGradebook contém uma referência a esse objeto Gradebook*/
        
        System.out.println("Digite o nome do curso.: ");
        
        //    myGradeBook.displayMessage();/*Chamar o método myGradeBook, vc não pode chamar um método que pertence à outra classe, até criar o objeto dessa classe*/
        Scanner input = new Scanner(System.in);
        
        String nameOfCurse=input.nextLine();
        
        System.out.println();

        
                
            myGradeBook.displayMessage(nameOfCurse);
        
    }
    
}
