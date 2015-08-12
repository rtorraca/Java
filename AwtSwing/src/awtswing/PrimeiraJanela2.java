/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package awtswing;

import javax.swing.*;
import java.awt.event.*;


/**
 *
 * @author robson
 */
public class PrimeiraJanela2 extends JFrame{
    
    public PrimeiraJanela2(){
        super("Nossa primeira janela - versão 2");
        setSize(300,150);
        setVisible(true);
        
    }
    
    
    public static void main(String args[])
    {
        PrimeiraJanela2 app = new PrimeiraJanela2();
        
        app.addWindowListener(
                
        new WindowAdapter(){
        
            public void windowClosing(WindowEvent e){
            
                String aviso = "A janela será fechada agora";
        
                JOptionPane.showMessageDialog(null,aviso);
        
                System.exit(0);
        }
        
}
        );
    }
    
}
