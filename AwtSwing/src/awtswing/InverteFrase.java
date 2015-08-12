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
 
 Inverte a frase
 */
public class InverteFrase {
    
    
    public static void main(String args[])
    {
    
    String frase, frase2 = "",palavras[];
    
    frase = JOptionPane.showInputDialog("Digite a frase");
    palavras = frase.split(" ");//split permite dividir uma cadeia de carecteres (string) 
    
    
    for (int i= palavras.length-1;i>=0;i--)
    {
   frase2 +=palavras[i]+" ";
    
    }
    
    JOptionPane.showMessageDialog(null, frase2.trim());//trim tira espaços em branco
    System.exit(0);
}

}