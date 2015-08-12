/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package awtswing;
import javax.swing.*;
/**
 *
 * @author robson
 
 livro: Página 43
 */
public class JanelaMaximizada extends JFrame{
    
    public JanelaMaximizada(){
        super("Como exibir a janela maximizada");
        setSize(300,150);
        setVisible(true);
        setExtendedState(MAXIMIZED_BOTH);
    }
    
  
    public static void main(String args[]){
        
        JanelaMaximizada app = new JanelaMaximizada();
        app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
 
}
