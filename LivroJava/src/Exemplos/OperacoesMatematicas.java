
package Exemplos;

import javax.print.attribute.standard.OutputDeviceAssigned;
import javax.swing.JOptionPane;

public class OperacoesMatematicas {

public static void main(String[] args) {

String firstNumber;
String secondNumber;
String subtracao;

int number1;
int number2;
int somar;
int multiplicar;
float dividir;
int subtrair;
String op;
int op_realizada;

//Capturando os numeros (em formato String) e atribuindo-os as variaveis "firstNumber" e "secondNumber";
firstNumber = JOptionPane.showInputDialog("Digite o primeiro numero");
secondNumber = JOptionPane.showInputDialog("Digite o Segundo numero");


//Transformando as variaveis "firstNumber" e "secondNumber" em numeros em inteiros;
number1 = Integer.parseInt(firstNumber);
number2 = Integer.parseInt(secondNumber);

//Operacoes;

somar = number1 + number2;
multiplicar = number1 * number2;
subtrair = number1 - number2;
dividir = number1/number2;

//Captura a operacao a ser feita;

op = JOptionPane.showInputDialog("Digite a operacao a ser feita\n\nPodendo ser\n*1 - Dividir\n*2 - "
        + "Somar\n*3 - Multiplicar ou \n*4 - Subtrair");


//testa se a opcao é "4",se a condicao for verdadeira faz a subtracao

if(op.equals("4")){

JOptionPane.showMessageDialog(null,"A subtracao é :" + subtrair ,"Resultado",JOptionPane.PLAIN_MESSAGE);

//testa se a opcao é "2",se a condicao for verdadeira faz a soma
}
else if (op.equals("2"))
{
JOptionPane.showMessageDialog(null,"A soma é :" + somar ,"Resultado",JOptionPane.PLAIN_MESSAGE);

//testa se a opcao é "3",se a condicao for verdadeira faz a multiplicacao
}else if ( op.equals("3"))
{
JOptionPane.showMessageDialog(null,"A multiplicacao é :" + multiplicar ,"Resultado",JOptionPane.PLAIN_MESSAGE);

//testa se a opcao é "1",se a condicao for verdadeira faz a divisao
}else if ( op.equals("1")){
JOptionPane.showMessageDialog(null,"A divisao é :" + dividir ,"Resultado",JOptionPane.PLAIN_MESSAGE);
}


//Exibindo o resultado
//JOptionPane.showMessageDialog( null,"O somatório é " + soma,"Resultado",JOptionPane.PLAIN_MESSAGE);

System.exit(0);

}

}
