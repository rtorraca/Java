/*
 Exemplo de Escopo de campo e variável local
 */

package EscopoVariaveis;

/**
 *
 * @author robson
 */
public class Scope {
    //campo acessível para todos os métodos dessa classe
    private int x = 1;//permanece sombreado, oculto em qualquer bloco(ou método)
    
public void begin(){
    
    int x = 5; //variável local x do método sombreia o campo x
System.out.printf("local x no método begin é .: %d\n",x);

useLocalVariable();// tem uma variável local
useField();//utiliza o campo x da classe scope
useLocalVariable();//reinializa a variável local x
useField();//campo x da classe Scope retém seu valor

System.out.printf("\n local x no metodo begin é.: %d\n",x);
}//fim do método begin

public void useLocalVariable(){
    int x=25;
    
    System.out.printf("\nlocal de x do método useLocalVariable is.: %d\n",x);
   ++x;//modifica a variável local x desse método
    System.out.printf("local x antes existir o método useLocalVariable.: %d\n ",x);
}//fim do método useLocalVariable

public void useField(){
    
    x *=10; // modifica o campo x da classe Scope
    System.out.printf("field x antes existing método useFiled is %d\n",x);
}//fim do método useField

}//fim da classe Scope
