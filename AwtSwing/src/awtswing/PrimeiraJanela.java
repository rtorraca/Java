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
 */
public class PrimeiraJanela extends JFrame{
   
    
    public PrimeiraJanela()
    {
        
    super("Nossa primeira Janela");
    setSize(300,150);
    setVisible(true);
    }
            

public static void main(String args[])
{
PrimeiraJanela app = new PrimeiraJanela();
app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

//app.setDefaultCloseOperation(JFrame.MAXIMIZED_VERT);

}
     
}