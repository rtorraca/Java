/*
 * Criando e manipulando um objeto GradeBook
 * Exemplo de uso dos métodos Get, Set e Construtor
 * Livro Deitel, Java Como Programar, pág: 68
 */

package L4;

/**
 *
 * @author robson
 */
public class GradeBook {
    
    
    private String courseName;
    
    /*Definindo o construtor*/
    public GradeBook(String name){
        
    courseName=name;
    }
     
    public void setCourseName(String name){
        
        courseName=name;
    
    }
     
    public String getCourseName(){
        return courseName;
        
    }
    
   
    public void displayMessage(){
    
        System.out.printf("Bem vindos ao curso de.: \n%s\n",getCourseName());    
    
    }
    
    
}
