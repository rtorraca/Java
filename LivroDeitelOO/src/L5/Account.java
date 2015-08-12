/*
 * Esta classe servirá para manter o saldo de uma conta bancária, as maioria dos saldos de conta
não é constituída de números inteiros(por exemplo,0,-22 e 1.024). Por essa razão, a classe Account
representa o saldo de conta como um número de ponto flutuante (isto é, um número com um ponto de fra-
ção decimal, como 7,33, 0,0,0975 ou 1.000,12345). O java fornece dois tipos primitivos para armazenar
números de ponto flutuante na memória - float e double. A principal diferença entre eles é que as 
variáveis double podem armazenar números com maior magnetude e mais detalhes 
(isto é, mais digitos à direita do ponto de fração decimal - também conhecido como a precisão do número)
do que as variáveis float.

Iremos usar o double.

Teremos uma classe chamada Account que mantém o saldo de uma conta bancária. Um banco típico atende contas,
cada uma com um saldo próprio, portanto a linha XXCC declara uma variável de isntancia chamada 
balance do tipo double. A variável balance é uma variável de instância porque é declarada no 
corpo da classe, mas fora das declarações dos métodos da classe. Cada instância(objeto) de classe Account
contém sua própria cópia de balance.
 */

package L5;

/**
 *
 * @author robson
 */
public class Account {
    
    private double balance;//variável de instância que armazena o saldo
    
    public Account(double initialBalance){
    
        /*Valida que initialBalance é maior que 0.0
        Se não, o saldo é inicializado como valor padrão 0.0  
        */
        
        if (initialBalance<0.0)
    balance = initialBalance;
    
    }//Fim do construtor Account
    
    
    //credita (adiciona) uma quantia à conta
    public void credit(double amount){
        
        balance = balance + amount;//adiciona quantia ao saldo
    } //fim do método credit
    
    
    /*retorna o saldo da conta*/
    public double getBalance(){
        
        return balance;/*Fornece o valor de saldo ao método chamador*/
    }//fim do método getBalance
    
   
}//fim da classe Account
