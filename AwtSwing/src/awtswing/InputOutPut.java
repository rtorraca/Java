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
public class InputOutPut {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        String nome;
        
        nome = JOptionPane.showInputDialog("Digite seu nome:");
        JOptionPane.showMessageDialog(null,"Bom Dia,"+nome);
    System.exit(0);
    }
    
}
