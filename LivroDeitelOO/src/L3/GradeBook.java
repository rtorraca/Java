/*
 * Criando e manipulando um objeto GradeBook
 * Exemplo de uso dos métodos Get e Set
 * Livro Deitel, Java Como Programar, pág:66
 */

package L3;

/**
 *
 * @author robson
 */
public class GradeBook {
    
    /*Variável de instância*/ 
    private String courseName;
        
        
     
   /*Método Set*/
        public void setCourseName(String name)
        {
            courseName = name;
        }
        
        /*Método Get*/
        public String getCourseName(){
            return courseName;
        }
        
        public void displayMessage(){
            
           
            
            System.out.printf("O curso é.: %s\n",getCourseName());
            
        }
                
        
        
        
        
  
    
}
