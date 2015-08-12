/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package awtswing;
import javax.swing.*;
import java.awt.*;

/**
 *
 * @author robson
 * Livro página :52
 */
public class Controles extends JFrame{
    
    public Controles(){
    super("Adicionando controles à Janela");
    
    Container tela = getContentPane();
    
    FlowLayout layout = new FlowLayout();
    
    tela.setLayout(layout);
   JButton btn = new JButton("Clique Aqui");
   setSize(300,150);
   setVisible(true);
   
    }
    
    
    public static void main(String args[])
    {
    Controles app = new Controles();
    app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);    
    
}

}