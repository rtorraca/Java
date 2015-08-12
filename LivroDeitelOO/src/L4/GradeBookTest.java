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
public class GradeBookTest {
    
    public static void main(String[] args) {
        
        /*Inicia os objetos utilizando o construtor */
        /*Criam e inicializam os objetos*/
        /*O contrutor Gradebook é chamado com os argumentos*/
        
        /*Expressão de criação de instância da classe*/
        GradeBook gradeBook1 = new GradeBook("Sistemas Operacionais");
        
        /*Expressão de criação de instância da classe, retorna uma referência do novo objeto
        que é atribuida á variável gradeBook2*/
        GradeBook gradeBook2 = new GradeBook("Redes de Computadores");
        
        
        /*Utiliza os métodos getCourseName de cada objeto para obter os nomes de curso e mostrar
        que eles foram inicializados quando os objetos foram criados, a saída confirma 
        que cada GradeBook mantém sua própria cópia de variável de instância courseName*/
        System.out.printf("O curso de GradeBook1 %s\n ",gradeBook1.getCourseName());
        
        System.out.printf("O curso de GradeBook2 %s\n ",gradeBook2.getCourseName());
        
        /*Obs.: Uma diferença entre construtores e métodos, é que construtores não 
        podem retornar valores, portanto, não podem específicar um tipo de 
        retorno(nem mesmo void), Normalmente os construtores são declarados public, 
        se uma classe não incluir um construtor, as variáveis de instância da classe
        são inicializadas como seus valores padrão. Se você declarar qualquer construtor para
        uma classe, o compilador Java não criará um construtor padrão para essa classe. 
        Assim, não é mais possível criar um objeto GradeBook com newGradeBook() como fizemos.*/
    }
    
}
