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
public class GetSO {
    
    
    public static void main(String args[])
    {
        
        String nome = System.getProperty("os.name");
        //System.out.println("O nome do sistema é : "+nome);
        
        JOptionPane.showMessageDialog(null,"O S.O usado é "+nome);//trim tira espaços em branco
        
        System.exit(0);
    }
    
    
}
