/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package awtswing;
import javax.swing.JOptionPane;

/**
 *
 * @author robson
 */

public class Fatorial{
    
    public static long fatorial(long num)
    {
    if (num<=1)
        return 1;

    else 
        
        return  num*fatorial(num-1);
        }



public static void main(String args[])
{

    long valor;
    
    String mensagem;
    
    valor = Integer.parseInt(JOptionPane.showInputDialog("Informe um inteiro"));
    
    mensagem = "O fatorial de "+valor+" é ";

JOptionPane.showMessageDialog(null,mensagem+fatorial(valor));
    
System.exit(0);
}
}

